package ru.senla.bialevich.service;

import ru.senla.bialevich.api.dao.GuestDao;
import ru.senla.bialevich.api.dao.OrderDao;
import ru.senla.bialevich.api.service.GuestService;
import ru.senla.bialevich.dao.GuestDaoImpl;
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

        for (Guest guest :guestDao.getAll()) {
            if (guest.getId() > maxId) {
                maxId = guest.getId();
            }
        }
        currentId = maxId + 1;
    }

    public void add(Guest guest) {
        guest.setId(currentId++);
        guestDao.add(guest);
        calcId();
    }

    @Override
    public Guest getGuestById(Integer id) {
        return guestDao.getGuestById(id);
    }

    public List<Guest> getAll() {

        return guestDao.getAll();
    }

    @Override
    public void update(Guest guest) {
        guestDao.update(guest);
    }

    public void delete(Guest guest) {
        guestDao.delete(guest);
    }

    @Override
    public Integer getTotalNumberOfGuests() {

        return guestDao.getAll().size();
    }

    @Override
    public List<Guest> sortedGuestsBySurname() {

        return copy.getCopiedAndSortedList(guestDao.getAll(), GuestSortComparators.SURNAME.getGuestComparator());
    }

    public void setRoomToGuest(Guest guest, Room room) {
        guestDao.setRoomToGuest(guest, room);
    }

    @Override
    public List<Guest> sortedGuestsByDateOfDeparture() {

        return copy.getCopiedAndSortedList(guestDao.getAll(), GuestSortComparators.DATE_OF_DEPARTURE.getGuestComparator());
    }

    @Override
    public List<UsedService> getServiceByGuest(Guest guest) {
        return guest.getRoom().getUsedServiceList();
    }

    @Override
    public List<Guest> getListGuests() {
        return guestDao.getAll();
    }

    @Override
    public void setOrderToGuest(Guest guest, Order order) {
        guestDao.setOrderToGuest(guest, order);
    }

    public void setGuestList(List<Guest> guests) {
        guestDao.setGuestList(guests);
    }
}
