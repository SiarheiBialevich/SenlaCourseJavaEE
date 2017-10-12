package ru.senla.bialevich.service;

import ru.senla.bialevich.api.dao.GuestDao;
import ru.senla.bialevich.api.service.GuestService;
import ru.senla.bialevich.dao.GuestDaoImpl;
import ru.senla.bialevich.entity.Guest;
import ru.senla.bialevich.entity.UsedService;
import ru.senla.bialevich.enums.GuestSortComparators;
import ru.senla.bialevich.util.CopyAndSortList;

import java.util.List;

public class GuestServiceImpl implements GuestService {
    private GuestDao guestDao = new GuestDaoImpl();
    private CopyAndSortList<Guest> copy = new CopyAndSortList<Guest>();

    public void add(Guest guest) {
        guestDao.add(guest);
    }

    @Override
    public Guest getGuestById(Integer id) {
        return guestDao.getGuestById(id);
    }

    public List<Guest> getAll() {

        return guestDao.getAll();
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
}
