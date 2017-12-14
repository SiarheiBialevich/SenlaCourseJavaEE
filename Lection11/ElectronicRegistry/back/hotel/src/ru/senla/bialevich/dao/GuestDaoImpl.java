package ru.senla.bialevich.dao;

import org.apache.log4j.Logger;
import ru.senla.bialevich.connectordb.ConnectorDb;
import ru.senla.bialevich.entity.Guest;
import ru.senla.bialevich.entity.Room;
import ru.senla.bialevich.entity.Service;
import ru.senla.bialevich.enums.entity.RoomStatus;
import ru.senla.bialevich.enums.entity.SortType;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static ru.senla.bialevich.util.parser.ParserResultSet.parseGuest;
import static ru.senla.bialevich.util.parser.ParserResultSet.parseService;

public class GuestDaoImpl extends AbstractDaoImpl<Guest> implements GuestDao {

    private final static Logger LOG = Logger.getLogger(GuestDaoImpl.class);

    private final String UPDATE_GUEST = "UPDATE guest SET name = ?, surname = ?, room_id = ? WHERE id = ?";
    private final String SET_GUEST = "INSERT INTO guests(name, surname) VALUES (?, ?) ";
    private final String GET_GUEST = "SELECT * FROM guests WHERE id = ?";
    private final String DELETE_GUEST = "DELETE * FROM guests WHERE id = ?";
    private final String GET_SORT_GUEST = "SELECT * FROM guests ORDER BY ";

    private final String TABLE_GUESTS = "guests";
    private final String TABLE_SERVICES = "services";
    private final String TABLE_REGISTRATIONS = "registrations";

    public GuestDaoImpl() {
    }

    @Override
    protected Guest assignParser(ResultSet set) {
        return parseGuest(set);
    }

    @Override
    protected String getInsertQuery() {
        return SET_GUEST;
    }

    @Override
    protected String getUpdateQuery() {
        return UPDATE_GUEST;
    }

    @Override
    protected String getDeleteQuery() {
        return DELETE_GUEST;
    }

    @Override
    protected String getByIdQuery() {
        return GET_GUEST;
    }

    @Override
    protected String getGetAllQuery(SortType type, RoomStatus status) {
        return GET_SORT_GUEST;
    }

    @Override
    protected void setPreparedStatementForInsert(PreparedStatement statement, Guest entity) throws SQLException {
        statement.setString(1, entity.getName());
        statement.setString(2, entity.getSurname());
    }

    @Override
    protected void setPreparedStatementForUpdate(PreparedStatement statement, Guest entity) throws SQLException {
        statement.setString(1, entity.getName());
        statement.setString(22, entity.getSurname());

        if (entity.getRoom() == null) {
            statement.setString(3, null);
        } else {
            statement.setInt(3, entity.getRoom().getId());
        }
        statement.setInt(4, entity.getId());
    }

    @Override
    public List<Service> getServices(Guest guest, SortType type, Connection connection) {
        List<Service> services = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM " + TABLE_SERVICES + " WHERE guests_id = ? ORDER BY ?")) {
            statement.setInt(1, guest.getId());
            statement.setString(2, type.toString());
            ResultSet set = statement.executeQuery();

            while (set.next()) {
                services.add(parseService(set));
            }

            set.close();
            statement.close();
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }

        return services;
    }

    @Override
    public List<Guest> getSortedByFinalDate(Connection connection) {
        List<Guest> guests = new ArrayList<>();

        try (Statement statement = connection.createStatement()) {

            ResultSet set = statement.executeQuery("SELECT * FROM " + TABLE_GUESTS + " JOIN " + TABLE_REGISTRATIONS +
                    " ON guests_id = registrations.guests_id ORDER BY registrations.final_date ");

            while (set.next()) {
                guests.add(parseGuest(set));
            }

            set.close();
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }

        return guests;
    }

    @Override
    public double getSumByRoom(Room room, Guest guest, Connection connection) {

        double sum = 0;

        try (PreparedStatement statement = connection.prepareStatement("SELECT start_date, final_date FROM " + TABLE_REGISTRATIONS + " WHERE guests_id = ? AND rooms_id = ?")) {
            statement.setInt(1, guest.getId());
            statement.setInt(2, room.getId());
            ResultSet set = statement.executeQuery();
            int count = 0;

            while (set.next()) {
                count = set.getDate(2).toLocalDate().getDayOfYear() - set.getDate(1).toLocalDate().getDayOfYear();
            }

            sum = count * room.getPrice();
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }

        return sum;
    }

    @Override
    public Integer getCount(Connection connection) {

        int count = 0;
        try (Statement statement = connection.createStatement()) {

            ResultSet set = statement.executeQuery("SELECT count(id) FROM " + TABLE_GUESTS);
            while (set.next()) {
                count = set.getInt(1);
            }
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }

        return count;
    }
}
