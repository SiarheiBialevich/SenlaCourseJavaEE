package ru.senla.bialevich.service;


import org.hibernate.Session;
import ru.senla.bialevich.connectordb.HibernateUtil;

public abstract class AbstractService {

    protected Session session = HibernateUtil.getCurrentSession();
}
