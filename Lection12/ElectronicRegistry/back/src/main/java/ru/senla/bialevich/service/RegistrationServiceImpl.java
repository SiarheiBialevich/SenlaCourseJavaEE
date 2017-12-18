package ru.senla.bialevich.service;

import org.apache.log4j.Logger;
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
        try {
            registrationDao.add(session, registration);
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        } finally {
            if (session != null)
                session.close();
        }
    }

    @SuppressWarnings("Duplicates")
    @Override
    public void update(Registration registration) {

        try {
            session.beginTransaction();
            registrationDao.update(session, registration);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            LOG.error(e.getMessage());
        } finally {
            if (session != null)
                session.close();
        }
    }

    @Override
    public double getSumByRoom(Room room, Guest guest) {
        double sum = 0;
        try {
            sum = registrationDao.getSumByRoom(session, room, guest);
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }finally {
            if (session != null)
                session.close();
        }

        return sum;
    }

    @Override
    public List<Guest> getSortedByFinalDate() {
        List<Guest> guests = null;
        try {
            guests = registrationDao.getSortedByFinalDate(session);
        }catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }finally {
            if (session != null)
                session.close();
        }
        return guests;
    }

    @Override
    public Registration getRegistration(int id) {
        Registration registration = null;
        try {
            registration = registrationDao.getById(session, id);
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }finally {
            if (session != null)
                session.close();
        }
        return registration;
    }

    @SuppressWarnings("Duplicates")
    @Override
    public List<Registration> getAll(SortType type) {
        List<Registration> registrations = null;
        try {
            registrations = registrationDao.getAll(session, type, null);
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }finally {
            if (session != null)
                session.close();
        }
        return registrations;
    }
}
