package ru.senla.bialevich.service;

import ru.senla.bialevich.dao.GuestDao;
import ru.senla.bialevich.dao.GuestDaoImpl;
import ru.senla.bialevich.dao.OrderDao;
import ru.senla.bialevich.entity.Guest;
import ru.senla.bialevich.entity.Order;
import ru.senla.bialevich.entity.Room;
import ru.senla.bialevich.entity.UsedService;
import ru.senla.bialevich.enums.comparator.GuestSortComparators;
import ru.senla.bialevich.util.CopyAndSortList;

import java.util.List;

public class GuestServiceImpl implements GuestService {
    private GuestDao guestDao = new GuestDaoImpl();
    private OrderDao orderDao;
    private CopyAndSortList<Guest> copy = new CopyAndSortList<Guest>();

    public GuestServiceImpl(GuestDao guestDao, OrderDao orderDao) {
        this.guestDao = guestDao;
        this.orderDao = orderDao;
    }

    public GuestServiceImpl() {
    }

    private Integer currentId = 1;

    private void calcId() {
        Integer maxId = 0;

        for (Guest guest : guestDao.getAll()) {
            if (guest.getId() > maxId) {
                maxId = guest.getId();
            }
        }
        currentId = maxId + 1;
    }

    public void add(Guest guest) {
        synchronized (guestDao) {
            currentId = guest.getId();
            guest.setId(currentId++);
            guestDao.add(guest);
            calcId();
        }
    }

    @Override
    public Guest getGuestById(Integer id) {
        synchronized (guestDao) {
            return guestDao.getGuestById(id);
        }
    }

    public List<Guest> getAll() {
        List<Guest> guests = null;
        synchronized (guestDao) {
            guests = guestDao.getAll();
        }
        return guests;
    }

    @Override
    public void update(Guest guest) {
        synchronized (guestDao) {
            guestDao.update(guest);
        }
    }

    public void delete(Guest guest) {
        synchronized (guestDao) {
            guestDao.delete(guest);
        }
    }

    @Override
    public Integer getTotalNumberOfGuests() {
        Integer totalGuest = null;
        synchronized (guestDao) {
            totalGuest = guestDao.getAll().size();
        }
        return totalGuest;
    }

    @Override
    public List<Guest> sortedGuestsBySurname() {
        synchronized (guestDao) {
            return copy.getCopiedAndSortedList(guestDao.getAll(), GuestSortComparators.SURNAME.getGuestComparator());
        }
    }

    public void setRoomToGuest(Guest guest, Room room) {
        synchronized (guestDao) {
            guestDao.setRoomToGuest(guest, room);
        }
    }

    @Override
    public List<Guest> sortedGuestsByDateOfDeparture() {
        synchronized (guestDao) {
            return copy.getCopiedAndSortedList(guestDao.getAll(), GuestSortComparators.DATE_OF_DEPARTURE.getGuestComparator());
        }
    }

    @Override
    public List<UsedService> getServiceByGuest(Guest guest) {
        return guest.getRoom().getUsedServiceList();
    }

    @Override
    public List<Guest> getListGuests() {
        synchronized (guestDao) {
            return guestDao.getAll();
        }
    }

    @Override
    public void setOrderToGuest(Guest guest, Order order) {
        synchronized (guestDao) {
            guestDao.setOrderToGuest(guest, order);
        }
    }

    public void setGuestList(List<Guest> guests) {
        synchronized (guestDao) {
            guestDao.setGuestList(guests);
        }
    }
}
