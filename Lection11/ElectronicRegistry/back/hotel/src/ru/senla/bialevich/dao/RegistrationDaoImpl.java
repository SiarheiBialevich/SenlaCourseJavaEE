package ru.senla.bialevich.dao;

import org.apache.log4j.Logger;
import ru.senla.bialevich.entity.Registration;
import ru.senla.bialevich.enums.entity.RoomStatus;
import ru.senla.bialevich.enums.entity.SortType;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import static ru.senla.bialevich.util.parser.ParserResultSet.parseRegistration;

public class RegistrationDaoImpl extends AbstractDaoImpl<Registration> implements RegistrationDao {

    private final static Logger LOG = Logger.getLogger(RegistrationDaoImpl.class);

    private final String UPDATE_REGISTRATION = "UPDATE registrations SET guests_id = ?, rooms_id = ?, start_date = ?, final_date = ? WHERE id = ?";
    private final String SET_REGISTRATION = "INSERT INTO registrations (start_date, final_date, rooms_id, guests_id) VALUES (?,?,?,?) ";
    private final String GET_REGISTRATION = "SELECT * FROM registrations WHERE id = ?";
    private final String DELETE_REGISTRATION = "DELETE * FROM registrations WHERE id = ?";
    private final String GET_SORT_REGISTRATION = "SELECT * FROM registrations ORDER BY ";
    private final SimpleDateFormat formatter = new SimpleDateFormat("YYYY-dd-MM");

    public RegistrationDaoImpl() {
    }

    @Override
    protected Registration assignParser(ResultSet set) {
        return parseRegistration(set);
    }

    @Override
    protected String getInsertQuery() {
        return SET_REGISTRATION;
    }

    @Override
    protected String getUpdateQuery() {
        return UPDATE_REGISTRATION;
    }

    @Override
    protected String getDeleteQuery() {
        return DELETE_REGISTRATION;
    }

    @Override
    protected String getByIdQuery() {
        return GET_REGISTRATION;
    }

    @Override
    protected String getGetAllQuery(SortType type, RoomStatus status) {
        return GET_SORT_REGISTRATION;
    }

    @Override
    protected void setPreparedStatementForInsert(PreparedStatement statement, Registration entity) throws SQLException {
        statement.setInt(1, entity.getGuestId());
        statement.setInt(2, entity.getRoomId());
        statement.setString(3, formatter.format(entity.getStartDate()));
        statement.setString(4, formatter.format(entity.getFinalDate()));
    }

    @Override
    protected void setPreparedStatementForUpdate(PreparedStatement statement, Registration entity) throws SQLException {
        statement.setInt(1, entity.getGuestId());
        statement.setInt(2, entity.getRoomId());
        statement.setString(3, formatter.format(entity.getStartDate()));
        statement.setString(4, formatter.format(entity.getFinalDate()));
        statement.setInt(5, entity.getId());
    }
}
