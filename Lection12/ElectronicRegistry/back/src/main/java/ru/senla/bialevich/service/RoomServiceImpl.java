package ru.senla.bialevich.service;

import org.apache.log4j.Logger;
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
        try {
            roomDao.add(session, room);
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        } finally {
            if (session != null)
                session.close();
        }
    }

    @SuppressWarnings("Duplicates")
    @Override
    public Room getRoom(int id) {
        Room room = null;
        try {
            room = roomDao.getById(session, id);
        } catch (Exception e) {
            LOG.error(e.getMessage());
        } finally {
            if (session != null)
                session.close();
        }
        return room;
    }

    @SuppressWarnings("Duplicates")
    @Override
    public void update(Room room) {
        try {
            session.beginTransaction();
            roomDao.update(session, room);
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
    public void delete(Room room) {
        try {
            roomDao.remove(session, room);
        } catch (Exception e) {
            LOG.error(e.getMessage());
        }finally {
            if (session != null)
                session.close();
        }
    }

    @Override
    public void registerGuest(Guest guest, Room room, Date startDate, Date finalDate) {
        try {
            guest.setRoom(room);
            guestDao.update(session, guest);
            Registration registration = new Registration(guest.getId(), room.getId(), startDate, finalDate);
            registrationDao.add(session, registration);
        } catch (Exception e) {
            LOG.error(e.getMessage());
        }finally {
            if (session != null)
                session.close();
        }
    }

    @Override
    public void evictGuest(Guest guest) {
        try {
            guest.setRoom(null);
            guestDao.update(session, guest);
        }catch (Exception e) {
            LOG.error(e.getMessage());
        }finally {
            if (session != null)
                session.close();
        }
    }

    @Override
    public Room cloneRoom(int id) {
        Room clone = null;
        try {
            Room room = roomDao.getById(session, id);
            clone = (Room) room.clone();
        }
        catch (Exception e) {
            LOG.error(e.getMessage());
        }finally {
            if (session != null)
                session.close();
        }
        return clone;
    }

    @SuppressWarnings("Duplicates")
    @Override
    public List<Room> getAll(SortType type) {
        List<Room> rooms = null;
        try {
            rooms = roomDao.getAll(session, type, null);
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }finally {
            if (session != null)
                session.close();
        }
        return rooms;
    }

    @Override
    public List<Room> getAllFree(SortType type) {
        List<Room> rooms = null;
        try {
            rooms = roomDao.getAll(session, type, RoomStatus.FREE);
        } catch (Exception e) {
            LOG.error(e.getMessage());
        }finally {
            if (session != null)
                session.close();
        }
        return rooms;
    }

    @Override
    public int getCountFreeRooms() {
        int count = 0;
        try {
            count = roomDao.getCountFreeRooms(session);
        } catch (Exception e) {
            LOG.error(e.getMessage());
        }finally {
            if (session != null)
                session.close();
        }
        return count;
    }

    @Override
    public List<Room> getReleasedInFuture(Date date) {
        List<Room> rooms = new ArrayList<>();
        try {
            rooms = roomDao.getReleasedInFuture(session, date);
        } catch (Exception e) {
            LOG.error(e.getMessage());
        }finally {
            if (session != null)
                session.close();
        }
        return rooms;
    }

    @Override
    public List<Room> getLatestGuests(int count) {
        List<Room> rooms = null;
        try {
            rooms = roomDao.getLatestGuests(session, count);
        } catch (Exception e) {
            LOG.error(e.getMessage());
        }finally {
            if (session != null)
                session.close();
        }
        return rooms;
    }

    @Override
    public List<Double> getPriceBySection(RoomSection section) {
        List<Double> prices = null;
        try {
            prices = roomDao.getPriceBySection(session, section);
        } catch (Exception e) {
            LOG.error(e.getMessage());
        }finally {
            if (session != null)
                session.close();
        }
        return prices;
    }
}
