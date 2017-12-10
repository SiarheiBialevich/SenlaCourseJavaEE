package ru.senla.bialevich.service;

import org.apache.log4j.Logger;
import ru.senla.bialevich.dao.GuestDao;
import ru.senla.bialevich.entity.Guest;
import ru.senla.bialevich.entity.Room;
import ru.senla.bialevich.entity.Service;
import ru.senla.bialevich.enums.entity.SortType;

import java.sql.SQLException;
import java.util.List;

public class GuestServiceImpl extends AbstractService implements GuestService {

    private static final Logger LOG = Logger.getLogger(GuestServiceImpl.class);

    private GuestDao guestDao;

    public GuestServiceImpl() {
    }

    @Override
    public void addGuest(Guest guest) {

        try {
            guestDao.add(guest, connection);
        } catch (Exception e) {
            LOG.error(e.getMessage());
        }
    }

    @Override
    public Guest getGuest(int id) {
        Guest guest = null;
        try {
            guest = guestDao.getById(id, connection);
        } catch (Exception e) {
            LOG.error(e.getMessage());
        }
        return guest;
    }

    @Override
    public void update(Guest guest) {

        boolean status = false;
        try {
            connection.setAutoCommit(false);
            status = guestDao.update(guest, connection);
            if (status) {
                connection.commit();
            }
        } catch (Exception e) {
            try {
                connection.rollback();
            } catch (SQLException sql) {
                sql.printStackTrace();
            }
            LOG.error(e.getMessage());
        }
    }

    @Override
    public void delete(Guest guest) {
        try {
            guestDao.remove(guest, connection);
        } catch (Exception e) {
            LOG.error(e.getMessage());
        }
    }

    @Override
    public void addService(Guest guest, Service service) {
    }

    @Override
    public void removeService(Guest guest, Service service) {
    }

    @Override
    public List<Service> getServices(Guest guest, SortType type) {
        List<Service> services = null;

        try {
            services = guestDao.getServices(guest, type, connection);
        } catch (Exception e) {
            LOG.error(e.getMessage());
        }
        return services;
    }

    @Override
    public List<Guest> getAll(SortType type) {
        List<Guest> guests = null;

        try {
            guests = guestDao.getAll(type, null, connection);
        } catch (Exception e) {
            LOG.error(e.getMessage());
        }
        return guests;
    }

    @Override
    public double getSumByRoom(Room room, Guest guest) {
        double sum = 0;

        try {
            sum = guestDao.getSumByRoom(room, guest, connection);
        } catch (Exception e) {
            LOG.error(e.getMessage());
        }
        return sum;
    }

    @Override
    public int getCount() {
        int count = 0;

        try {
            count = guestDao.getCount(connection);
        } catch (Exception e) {
            LOG.error(e.getMessage());
        }
        return count;
    }

    public void setGuestDao(GuestDao guestDao) {
        this.guestDao = guestDao;
    }
}
