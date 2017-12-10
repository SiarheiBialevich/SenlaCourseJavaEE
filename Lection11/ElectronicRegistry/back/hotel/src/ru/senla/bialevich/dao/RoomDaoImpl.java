package ru.senla.bialevich.dao;

import org.apache.log4j.Logger;
import ru.senla.bialevich.connectordb.ConnectorDb;
import ru.senla.bialevich.entity.Guest;
import ru.senla.bialevich.entity.Room;
import ru.senla.bialevich.entity.Service;
import ru.senla.bialevich.enums.entity.RoomSection;
import ru.senla.bialevich.enums.entity.RoomStatus;
import ru.senla.bialevich.enums.entity.SortType;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static ru.senla.bialevich.util.parser.ParserResultSet.parseRoom;

public class RoomDaoImpl extends AbstractDaoImpl<Room> implements RoomDao {

    private final static Logger LOG = Logger.getLogger(RoomDaoImpl.class);

    private final String UPDATE_ROOM = "UPDATE rooms SET price = ?, capacity = ?, status = ?, section = ?, rating = ? WHERE id = ?";
    private final String SET_ROOM = "INSERT INTO rooms (price, capacity, status, section, rating) VALUES (?,?,?,?,?) ";
    private final String GET_ROOM = "SELECT * FROM rooms WHERE id = ?";
    private final String DELETE_ROOM = "DELETE * FROM rooms WHERE id = ?";
    private final String GET_SORT_ROOM_FREE = "SELECT * FROM rooms WHERE status = 'free' ORDER BY ";
    private final String GET_SORT_ROOM = "SELECT * FROM rooms ORDER BY ";
    private final SimpleDateFormat formatter = new SimpleDateFormat("YYYY-dd-MM");

    public RoomDaoImpl() {
    }

    @Override
    protected Room assignParser(ResultSet set) {
        return parseRoom(set);
    }

    @Override
    protected String getInsertQuery() {
        return SET_ROOM;
    }

    @Override
    protected String getUpdateQuery() {
        return UPDATE_ROOM;
    }

    @Override
    protected String getDeleteQuery() {
        return DELETE_ROOM;
    }

    @Override
    protected String getByIdQuery() {
        return GET_ROOM;
    }

    @Override
    protected String getGetAllQuery(SortType type, RoomStatus status) {

        if(status != null) {
            return GET_SORT_ROOM_FREE;
        }else {
            return GET_SORT_ROOM;
        }
    }

    @Override
    protected void setPreparedStatementForInsert(PreparedStatement statement, Room entity) throws SQLException {
        statement.setDouble(1, entity.getPrice());
        statement.setInt(2, entity.getCapacity());
        statement.setString(3, entity.getStatus().toString());
        statement.setString(4, entity.getSection().toString());
        statement.setInt(5, entity.getRating());
    }

    @Override
    protected void setPreparedStatementForUpdate(PreparedStatement statement, Room entity) throws SQLException {
        statement.setDouble(1, entity.getPrice());
        statement.setInt(2, entity.getCapacity());
        statement.setString(3, entity.getStatus().toString());
        statement.setString(4, entity.getSection().toString());
        statement.setInt(5, entity.getRating());
        statement.setInt(6, entity.getId());
    }

    @Override
    public Integer getCountFreeRoom(Connection connection) {
        Statement statement = null;
        int count = 0;

        try {
            statement = connection.createStatement();
            ResultSet set = statement.executeQuery("SELECT count(*) FROM rooms WHERE status = 'free'");
            while (set.next()) {
                count = set.getInt(1);
            }
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }finally {
            ConnectorDb.getInstance().closeStatement(statement);
        }

        return count;
    }

    @Override
    public List<Room> getLatestGuest(Integer count, Connection connection) {
        PreparedStatement statement = null;
        List<Room> rooms = new ArrayList<>();

        try {
            List<Integer> list = new ArrayList<>();
            statement = connection.prepareStatement("SELECT DISTINCT rooms_id FROM registrations JOIN rooms ON registrations.rooms_id = rooms.id ORDER BY id DESC LIMIT ?");
            statement.setInt(1, count);
            ResultSet set = statement.executeQuery();

            while (set.next()) {
                list.add(set.getInt(1));
            }

            for (Integer aList : list) {
                set = statement.executeQuery("SELECT * FROM rooms WHERE id = ?");
                statement.setInt(1, aList);
                statement.executeQuery();
                rooms.add(parseRoom(set));
            }

        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }finally {
            ConnectorDb.getInstance().closeStatement(statement);
        }

        return rooms;
    }

    @Override
    public List<Room> getReleasedInFuture(Date date, Connection connection) {
        PreparedStatement statement = null;
        List<Room> rooms = new ArrayList<>();

        try {
            String currentDate = formatter.format(date);
            statement = connection.prepareStatement("SELECT * FROM rooms JOIN registrations ON rooms.id = registrations.rooms_id WHERE final_date < " + currentDate);
            ResultSet set = statement.executeQuery();

            while (set.next()) {
                rooms.add(parseRoom(set));
            }

        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }finally {
            ConnectorDb.getInstance().closeStatement(statement);
        }

        return rooms;
    }

    @Override
    public List<Double> getPriceBySection(RoomSection section, Connection connection) {
        PreparedStatement statement = null;
        List<Double> prices = new ArrayList<>();

        try {
            statement = connection.prepareStatement("SELECT price FROM rooms ORDER BY ?");
            statement.setString(1, section.toString());
            ResultSet set = statement.executeQuery();

            while (set.next()) {
                prices.add(set.getDouble(1));
            }

            set.close();
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }finally {
            ConnectorDb.getInstance().closeStatement(statement);
        }

        return prices;
    }
}
