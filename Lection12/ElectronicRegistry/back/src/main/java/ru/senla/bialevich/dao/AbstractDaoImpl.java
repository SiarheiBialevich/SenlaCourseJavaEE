package ru.senla.bialevich.dao;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import ru.senla.bialevich.model.BaseEntity;
import ru.senla.bialevich.enums.RoomStatus;
import ru.senla.bialevich.enums.SortType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractDaoImpl<T extends BaseEntity> implements AbstractDao<T> {

    private static final Logger LOG = Logger.getLogger(AbstractDaoImpl.class);

    private Class<T> clazz;

    protected AbstractDaoImpl(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public void update(Session session, T entity) {

        try {
            session.update(entity);
        } catch (Exception e) {
            LOG.error("Error in dao, update method", e);
        }
    }

    @Override
    public T getById(Session session, Integer id) {

        T model = null;

        try {
            model = (T) session.get(clazz, id);
        } catch (Exception e) {
            LOG.error("Error in dao, getById method", e);
        }
        return model;
    }

    @Override
    public void add(Session session, T entity) {

        try {
            session.save(entity);
        } catch (Exception e) {
            LOG.error("Error in dao, add method", e);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<T> getAll(Session session, SortType type, RoomStatus status) {
        if(type == null) {
            type = SortType.id;
        }
        Criteria criteria = session.createCriteria(clazz)
                .addOrder(Order.asc(type.toString()));
        if(status != null) {
            criteria.add(Restrictions.like("status", status));
        }

        return criteria.list();
    }

    @Override
    public void remove(Session session, T entity) {

        try {
            session.delete(entity);
        } catch (Exception e) {
            LOG.error("Error in dao, remove method", e);
        }
    }
}
