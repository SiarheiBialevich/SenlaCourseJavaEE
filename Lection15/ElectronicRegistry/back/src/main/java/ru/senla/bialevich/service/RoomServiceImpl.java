package ru.senla.bialevich.service;

import org.apache.log4j.Logger;
import ru.senla.bialevich.connectordb.HibernateUtil;
import ru.senla.bialevich.dao.GuestDao;
import ru.senla.bialevich.dao.RegistrationDao;
import ru.senla.bialevich.dao.RoomDao;
import ru.senla.bialevich.dependency.DependencyInjection;
import ru.senla.bialevich.enums.RoomSection;
import ru.senla.bialevich.enums.RoomStatus;
import ru.senla.bialevich.enums.SortType;
import ru.senla.bialevich.model.Guest;
import ru.senla.bialevich.model.Registration;
import ru.senla.bialevich.model.Room;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RoomServiceImpl extends AbstractService implements RoomService {

    private static final Logger LOG = Logger.getLogger(RoomServiceImpl.class);

    private RoomDao roomDao = (RoomDao) DependencyInjection.getInjection().getInstance(RoomDao.class);
    private GuestDao guestDao = (GuestDao) DependencyInjection.getInjection().getInstance(GuestDao.class);
    private RegistrationDao registrationDao = (RegistrationDao) DependencyInjection.getInjection().getInstance(RegistrationDao.class);


    public RoomServiceImpl() {
    }

    @SuppressWarnings("Duplicates")
    @Override
    public void addRoom(Room room) {

        session = HibernateUtil.getCurrentSession();

        try {
            session.beginTransaction();
            roomDao.add(session, room);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            LOG.error(e.getMessage(), e);
        }
    }

    @SuppressWarnings("Duplicates")
    @Override
    public Room getRoom(int id) {

        session = HibernateUtil.getCurrentSession();

        Room room = null;
        try {
            session.beginTransaction();
            room = roomDao.getById(session, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            LOG.error(e.getMessage());
        }

        return room;
    }

    @SuppressWarnings("Duplicates")
    @Override
    public void update(Room room) {

        session = HibernateUtil.getCurrentSession();

        try {
            session.beginTransaction();
            roomDao.update(session, room);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            LOG.error(e.getMessage(), e);
        }
    }

    @Override
    public void delete(Room room) {

        session = HibernateUtil.getCurrentSession();

        try {
            session.beginTransaction();
            roomDao.remove(session, room);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            LOG.error(e.getMessage());
        }
    }

    @Override
    public void registerGuest(Guest guest, Room room, Date startDate, Date finalDate) {

        session = HibernateUtil.getCurrentSession();

        try {
            session.beginTransaction();
            guest.setRoom(room);
            guestDao.update(session, guest);
            Registration registration = new Registration(guest.getId(), room.getId(), startDate, finalDate);
            registrationDao.add(session, registration);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            LOG.error(e.getMessage());
        }
    }

    @Override
    public void evictGuest(Guest guest) {

        session = HibernateUtil.getCurrentSession();

        try {
            session.beginTransaction();
            guest.setRoom(null);
            guestDao.update(session, guest);
            session.getTransaction().commit();
        }catch (Exception e) {
            session.getTransaction().rollback();
            LOG.error(e.getMessage());
        }
    }

    @Override
    public Room cloneRoom(int id) {

        session = HibernateUtil.getCurrentSession();

        Room clone = null;
        try {
            session.beginTransaction();
            Room room = roomDao.getById(session, id);
            clone = (Room) room.clone();
            session.getTransaction().commit();
        }
        catch (Exception e) {
            session.getTransaction().rollback();
            LOG.error(e.getMessage());
        }

        return clone;
    }

    @SuppressWarnings("Duplicates")
    @Override
    public List<Room> getAll(SortType type) {

        session = HibernateUtil.getCurrentSession();

        List<Room> rooms = null;
        try {
            session.beginTransaction();
            rooms = roomDao.getAll(session, type, null);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            LOG.error(e.getMessage(), e);
        }

        return rooms;
    }

    @Override
    public List<Room> getAllFree(SortType type) {

        session = HibernateUtil.getCurrentSession();

        List<Room> rooms = null;
        try {
            session.beginTransaction();
            rooms = roomDao.getAll(session, type, RoomStatus.FREE);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            LOG.error(e.getMessage());
        }

        return rooms;
    }

    @Override
    public int getCountFreeRooms() {

        session = HibernateUtil.getCurrentSession();

        int count = 0;
        try {
            session.beginTransaction();
            count = roomDao.getCountFreeRooms(session);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            LOG.error(e.getMessage());
        }

        return count;
    }

    @Override
    public List<Room> getReleasedInFuture(Date date) {

        session = HibernateUtil.getCurrentSession();

        List<Room> rooms = new ArrayList<>();
        try {
            session.beginTransaction();
            rooms = roomDao.getReleasedInFuture(session, date);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            LOG.error(e.getMessage());
        }

        return rooms;
    }

    @Override
    public List<Room> getLatestGuests(int count) {

        session = HibernateUtil.getCurrentSession();

        List<Room> rooms = null;
        try {
            session.beginTransaction();
            rooms = roomDao.getLatestGuests(session, count);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            LOG.error(e.getMessage());
        }

        return rooms;
    }

    @Override
    @SuppressWarnings("Duplicates")
    public List<Double> getPriceBySection(RoomSection section) {

        session = HibernateUtil.getCurrentSession();

        List<Double> prices = null;
        try {
            session.beginTransaction();
            prices = roomDao.getPriceBySection(session, section);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            LOG.error(e.getMessage());
        }

        return prices;
    }
}
