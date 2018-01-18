package ru.senla.bialevich.service;

import org.apache.log4j.Logger;
import ru.senla.bialevich.connectordb.HibernateUtil;
import ru.senla.bialevich.dao.RegistrationDao;
import ru.senla.bialevich.dependency.DependencyInjection;
import ru.senla.bialevich.enums.SortType;
import ru.senla.bialevich.model.Guest;
import ru.senla.bialevich.model.Registration;
import ru.senla.bialevich.model.Room;

import java.util.List;

public class RegistrationServiceImpl extends AbstractService implements RegistrationService {

    private static final Logger LOG = Logger.getLogger(RegistrationServiceImpl.class);

    private RegistrationDao registrationDao = (RegistrationDao) DependencyInjection.getInjection().getInstance(RegistrationDao.class);

    public RegistrationServiceImpl() {
    }

    @SuppressWarnings("Duplicates")
    @Override
    public void addRecord(Registration registration) {

        session = HibernateUtil.getCurrentSession();

        try {
            session.beginTransaction();
            registrationDao.add(session, registration);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            LOG.error(e.getMessage(), e);
        }
    }

    @SuppressWarnings("Duplicates")
    @Override
    public void update(Registration registration) {

        session = HibernateUtil.getCurrentSession();

        try {
            session.beginTransaction();
            registrationDao.update(session, registration);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            LOG.error(e.getMessage());
        }
    }

    @Override
    public double getSumByRoom(Room room, Guest guest) {

        session = HibernateUtil.getCurrentSession();

        double sum = 0;
        try {
            session.beginTransaction();
            sum = registrationDao.getSumByRoom(session, room, guest);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            LOG.error(e.getMessage(), e);
        }

        return sum;
    }

    @Override
    public List<Guest> getSortedByFinalDate() {

        session = HibernateUtil.getCurrentSession();

        List<Guest> guests = null;
        try {
            session.beginTransaction();
            guests = registrationDao.getSortedByFinalDate(session);
            session.getTransaction().commit();
        }catch (Exception e) {
            session.getTransaction().rollback();
            LOG.error(e.getMessage(), e);
        }

        return guests;
    }

    @Override
    public Registration getRegistration(int id) {

        session = HibernateUtil.getCurrentSession();

        Registration registration = null;
        try {
            session.beginTransaction();
            registration = registrationDao.getById(session, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            LOG.error(e.getMessage(), e);
        }

        return registration;
    }

    @SuppressWarnings("Duplicates")
    @Override
    public List<Registration> getAll(SortType type) {

        session = HibernateUtil.getCurrentSession();

        List<Registration> registrations = null;
        try {
            session.beginTransaction();
            registrations = registrationDao.getAll(session, type, null);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            LOG.error(e.getMessage(), e);
        }

        return registrations;
    }
}
