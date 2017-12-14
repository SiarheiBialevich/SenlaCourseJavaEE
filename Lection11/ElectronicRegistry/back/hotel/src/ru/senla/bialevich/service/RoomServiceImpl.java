package ru.senla.bialevich.service;

import org.apache.log4j.Logger;
import ru.senla.bialevich.dao.GuestDao;
import ru.senla.bialevich.dao.RegistrationDao;
import ru.senla.bialevich.dao.RoomDao;
import ru.senla.bialevich.dependency.DependencyInjection;
import ru.senla.bialevich.entity.Guest;
import ru.senla.bialevich.entity.Registration;
import ru.senla.bialevich.entity.Room;
import ru.senla.bialevich.enums.entity.RoomSection;
import ru.senla.bialevich.enums.entity.RoomStatus;
import ru.senla.bialevich.enums.entity.SortType;

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

    @Override
    public void addRoom(Room room) {
        try {
            roomDao.add(room, connection);
        } catch (Exception e) {
            LOG.error(e.getMessage());
        }
    }

    @Override
    public Room getRoom(Integer id) {
        Room room = null;
        try {
            room = roomDao.getById(id, connection);
        } catch (Exception e) {
            LOG.error(e.getMessage());
        }
        return room;
    }

    @Override
    public void update(Room room) {
        boolean status = false;
        try {
            connection.setAutoCommit(false);
            status = roomDao.update(room, connection);
            if (status) {
                connection.commit();
            }
        } catch (Exception e) {
            try {
                connection.rollback();
            } catch (SQLException sql) {
                LOG.error(sql.getMessage());
            }
            LOG.error(e.getMessage());
        }
    }

    @Override
    public void delete(Room room) {
        try {
            roomDao.remove(room, connection);
        } catch (Exception e) {
            LOG.error(e.getMessage());
        }
    }

    @Override
    public void registerGuest(Guest guest, Room room, Date startDate, Date finalDate) {
        try {
            guest.setRoom(room);
            guestDao.update(guest, connection);
            Registration registration = new Registration(guest.getId(), room.getId(), startDate, finalDate);
            registrationDao.add(registration, connection);
        } catch (Exception e) {
            LOG.error(e.getMessage());
        }
    }

    @Override
    public void evictGuest(Guest guest) {
        try {
            guest.setRoom(null);
            guestDao.update(guest, connection);
        } catch (Exception e) {
            LOG.error(e.getMessage());
        }
    }

    @Override
    public Room cloneRoom(Integer id) {
        Room room = null;
        Room clone = null;

        try {
            room = roomDao.getById(id, connection);
            clone = (Room) room.clone();
        } catch (CloneNotSupportedException | SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return clone;
    }

    @Override
    public List<Room> getAll(SortType type) {
        List<Room> rooms = null;
        try {
            rooms = roomDao.getAll(type, null, connection);
        } catch (Exception e) {
            LOG.error(e.getMessage());
        }
        return rooms;
    }

    @Override
    public List<Room> getAllFree(SortType type) {
        List<Room> rooms = null;
        try {
            rooms = roomDao.getAll(type, RoomStatus.FREE, connection);
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
        return rooms;
    }

    @Override
    public int getCountFreeRooms() {
        int count = 0;
        try {
            count = roomDao.getCountFreeRoom(connection);
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
        return count;
    }

    @Override
    public List<Room> getReleasedInFuture(Date date) {
        List<Room> rooms = new ArrayList<>();
        try {
            roomDao.getReleasedInFuture(date, connection);
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
        return rooms;
    }

    @Override
    public List<Room> getLatestGuests(Integer count) {
        List<Room> rooms = null;
        try {
            rooms = roomDao.getLatestGuest(count, connection);
        } catch (Exception e) {
            LOG.error(e.getMessage());
        }
        return rooms;
    }

    @Override
    public List<Double> getPriceBySection(RoomSection section) {
        List<Double> prices = null;
        try {
            prices = roomDao.getPriceBySection(section, connection);
        } catch (Exception e) {
            LOG.error(e.getMessage());
        }
        return prices;
    }

    public void setRoomDao(RoomDao roomDao) {
        this.roomDao = roomDao;
    }

    public void setGuestDao(GuestDao guestDao) {
        this.guestDao = guestDao;
    }

    public void setRegistrationDao(RegistrationDao registrationDao) {
        this.registrationDao = registrationDao;
    }
}
