package ru.senla.bialevich.service;

import org.apache.log4j.Logger;
import ru.senla.bialevich.dao.GuestDao;
import ru.senla.bialevich.dependency.DependencyInjection;
import ru.senla.bialevich.enums.SortType;
import ru.senla.bialevich.model.Guest;
import ru.senla.bialevich.model.Room;
import ru.senla.bialevich.model.Service;

import java.util.List;

public class GuestServiceImpl extends AbstractService implements GuestService {

    private static final Logger LOG = Logger.getLogger(GuestServiceImpl.class);

    private GuestDao guestDao = (GuestDao) DependencyInjection.getInjection().getInstance(GuestDao.class);

    public GuestServiceImpl() {
    }

    @Override
    public void addGuest(Guest guest) {

        try {
            guestDao.add(session, guest);
        } catch (Exception e) {
            LOG.error(e.getMessage());
        } finally {
            if (session != null)
                session.close();
        }
    }

    @SuppressWarnings("Duplicates")
    @Override
    public Guest getGuest(int id) {
        Guest guest = null;
        try {
            guest = guestDao.getById(session, id);
        } catch (Exception e) {
            LOG.error(e.getMessage());
        } finally {
            if (session != null)
                session.close();
        }
        return guest;
    }

    @SuppressWarnings("Duplicates")
    @Override
    public void update(Guest guest) {

        boolean status = false;
        try {
            session.beginTransaction();
            guestDao.update(session, guest);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            LOG.error(e.getMessage(), e);
        } finally {
            if (session != null)
                session.close();
        }
    }

    @Override
    public void delete(Guest guest) {
        try {
            guestDao.remove(session, guest);
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }finally {
            if (session != null)
                session.close();
        }
    }

    @Override
    public List<Guest> getAll(SortType type) {
        List<Guest> guests = null;

        try {
            guests = guestDao.getAll(session, type, null);
        } catch (Exception e) {
            LOG.error(e.getMessage());
        }finally {
            if (session != null)
                session.close();
        }

        return guests;
    }

    @Override
    public int getCount() {
        int count = 0;

        try {
            count = guestDao.getCount(session);
        } catch (Exception e) {
            LOG.error(e.getMessage());
        }finally {
            if (session != null)
                session.close();
        }

        return count;
    }
}
