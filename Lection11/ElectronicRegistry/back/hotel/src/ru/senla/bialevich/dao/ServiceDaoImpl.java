package ru.senla.bialevich.dao;

import org.apache.log4j.Logger;
import ru.senla.bialevich.connectordb.ConnectorDb;
import ru.senla.bialevich.entity.Service;
import ru.senla.bialevich.enums.entity.RoomStatus;
import ru.senla.bialevich.enums.entity.ServicesSection;
import ru.senla.bialevich.enums.entity.SortType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import static ru.senla.bialevich.util.parser.ParserResultSet.parseService;

public class ServiceDaoImpl extends AbstractDaoImpl<Service> implements ServiceDao {

    private final static Logger LOG = Logger.getLogger(RoomDaoImpl.class);

    private final String UPDATE_SERVICE = "UPDATE guests SET name = ?, price = ?, section = ?, startDate = ?, finalDate = ? WHERE id = ?";
    private final String SET_SERVICE = "INSERT INTO services (name, price, section, start_date, final_date) VALUES (?,?,?,?,?) ";
    private final String GET_SERVICE = "SELECT * FROM services WHERE id = ?";
    private final String DELETE_SERVICE = "DELETE * FROM services WHERE id = ?";
    private final String GET_SORT_SERVICE = "SELECT * FROM services ORDER BY ";

    private final String TABLE_SERVICES = "services";

    private final SimpleDateFormat formatter = new SimpleDateFormat("YYYY-dd-MM");

    public ServiceDaoImpl() {
    }

    @Override
    public Service assignParser(ResultSet set) {
        return parseService(set);
    }

    @Override
    protected String getInsertQuery() {
        return SET_SERVICE;
    }

    @Override
    protected String getUpdateQuery() {
        return UPDATE_SERVICE;
    }

    @Override
    protected String getDeleteQuery() {
        return DELETE_SERVICE;
    }

    @Override
    protected String getByIdQuery() {
        return GET_SERVICE;
    }

    @Override
    protected String getGetAllQuery(SortType type, RoomStatus status) {
        return GET_SORT_SERVICE;
    }

    @Override
    protected void setPreparedStatementForInsert(PreparedStatement statement, Service entity) throws SQLException {
        statement.setString(1, entity.getName());
        statement.setDouble(2, entity.getPrice());
        statement.setString(3, entity.getSection().toString());
        statement.setString(4, formatter.format(entity.getStarDate()));
        statement.setString(5, formatter.format(entity.getFinalDate()));
    }

    @Override
    protected void setPreparedStatementForUpdate(PreparedStatement statement, Service entity) throws SQLException {
        statement.setString(1, entity.getName());
        statement.setDouble(2, entity.getPrice());
        statement.setString(3, entity.getSection().toString());
        statement.setString(4, formatter.format(entity.getStarDate()));
        statement.setString(5, formatter.format(entity.getFinalDate()));
        statement.setInt(6, entity.getId());
    }

    @Override
    public List<Double> getPriceBySection(ServicesSection section, Connection connection) {

        List<Double> prices = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement("SELECT price FROM " + TABLE_SERVICES + " ORDER BY ?")) {
            statement.setString(1, section.toString());
            ResultSet set = statement.executeQuery();
            while (set.next()) {
                prices.add(set.getDouble(1));
            }
            set.close();
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }

        return prices;
    }
}
