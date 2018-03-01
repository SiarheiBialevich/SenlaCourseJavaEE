package ru.senla.bialevich.dao;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.senla.bialevich.dao.api.IAbstractDao;
import ru.senla.bialevich.entity.BaseEntity;

import java.util.List;

@Repository
public abstract class AbstractDaoImpl<T extends BaseEntity> implements IAbstractDao<T> {

    private static final Logger LOG = Logger.getLogger(AbstractDaoImpl.class);

    private Class<T> clazz;

    @Autowired
    private SessionFactory sessionFactory;

    protected AbstractDaoImpl() {
    }

    public void setClazz(Class<T> clazz) {
        this.clazz = clazz;
    }

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<T> getAll() {
        Criteria criteria = getSession().createCriteria(clazz);
        return criteria.list();
    }

    @Override
    @SuppressWarnings("unchecked")
    public T getById(Integer id) {
        Criteria criteria;

        try {
            criteria = getSession().createCriteria(clazz).add(Restrictions.eq("id", id));
        } catch (Exception e) {
            LOG.error("Error in dao, getById method", e);
            throw e;
        }

        return (T) criteria.list().get(0);
    }

    @Override
    public void add(T entity) {
        try {
            sessionFactory.getCurrentSession().save(entity);
        } catch (Exception e) {
            LOG.error("Error in dao, add method", e);
            throw e;
        }
    }

    @Override
    public void update(T entity) {
        try {
            sessionFactory.getCurrentSession().update(entity);
        } catch (Exception e) {
            LOG.error("Error in dao, update method", e);
            throw e;
        }
    }

    @Override
    public void delete(T entity) {
        try {
            sessionFactory.getCurrentSession().delete(entity);
        } catch (Exception e) {
            LOG.error("Error in dao, remove method", e);
            throw e;
        }
    }
}
