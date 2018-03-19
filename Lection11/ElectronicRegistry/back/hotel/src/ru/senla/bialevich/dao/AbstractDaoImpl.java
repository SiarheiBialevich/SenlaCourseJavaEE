package ru.senla.bialevich.dao;

import org.apache.log4j.Logger;
import ru.senla.bialevich.connectordb.ConnectorDb;
import ru.senla.bialevich.entity.BaseEntity;
import ru.senla.bialevich.enums.entity.RoomStatus;
import ru.senla.bialevich.enums.entity.SortType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractDaoImpl<T extends BaseEntity> implements AbstractDao<T> {

    private static final Logger LOG = Logger.getLogger(AbstractDaoImpl.class);

    protected abstract T assignParser(ResultSet set);

    protected abstract String getInsertQuery();

    protected abstract String getUpdateQuery();

    protected abstract String getDeleteQuery();

    protected abstract String getByIdQuery();

    protected abstract String getGetAllQuery(SortType type, RoomStatus status);

    protected abstract void setPreparedStatementForInsert(PreparedStatement statement, T entity) throws SQLException;

    protected abstract void setPreparedStatementForUpdate(PreparedStatement statement, T entity) throws SQLException;

    public Boolean update(T entity, Connection connection) {

        Boolean status = false;
        try (PreparedStatement statement = connection.prepareStatement(getUpdateQuery())) {

            setPreparedStatementForUpdate(statement, entity);

            Integer count = statement.executeUpdate();

            status = (count > 0);
        } catch (SQLException e) {
            LOG.error(e.getMessage());
        }

        return status;
    }

    public T getById(Integer id, Connection connection) {

        T entity = null;

        try (PreparedStatement statement = connection.prepareStatement(getUpdateQuery())) {
            statement.setInt(1, id);
            entity = assignParser(statement.executeQuery());

        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }

        return entity;
    }

    public void add( T entity, Connection connection) {

        try (PreparedStatement statement = connection.prepareStatement(getUpdateQuery())) {
            setPreparedStatementForInsert(statement, entity);
            statement.executeUpdate();
        } catch (SQLException e) {
            LOG.error(e.getMessage());
        }
    }

    public List<T> getAll(SortType type, RoomStatus status, Connection connection) {
        List<T> list = new ArrayList<>();

        ResultSet set = null;

        try (PreparedStatement statement = connection.prepareStatement(getUpdateQuery())) {
            set = statement.executeQuery();
            while (set.next()) {
                list.add(assignParser(set));
            }
        } catch (SQLException e) {
            LOG.error(e.getMessage());
        }

        return list;
    }

    public void remove( T entity, Connection connection) {
        try (PreparedStatement statement = connection.prepareStatement(getUpdateQuery())) {
            statement.setInt(1, entity.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            LOG.error(e.getMessage());
        }
    }
}
