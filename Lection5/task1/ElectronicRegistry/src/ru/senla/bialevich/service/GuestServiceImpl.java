package ru.senla.bialevich.service;

import ru.senla.bialevich.api.dao.GuestDao;
import ru.senla.bialevich.api.service.GuestService;
import ru.senla.bialevich.dao.GuestDaoImpl;
import ru.senla.bialevich.entity.Guest;
import ru.senla.bialevich.enums.ServiceConstEnum;
import ru.senla.bialevich.util.CopyAndSortList;
import ru.senla.bialevich.util.Printer;
import ru.senla.bialevich.util.comparator.guestComparator.GuestDateOfDepartureComparator;
import ru.senla.bialevich.util.comparator.guestComparator.GuestSurnameComparator;

import java.util.List;

public class GuestServiceImpl implements GuestService {
    private static final GuestSurnameComparator SURNAME_COMPARATOR = new GuestSurnameComparator();
    private static final GuestDateOfDepartureComparator DATE_OF_DEPARTURE_COMPARATOR = new GuestDateOfDepartureComparator();

    private GuestDao guestDao = new GuestDaoImpl();
    private Printer printer = new Printer();
    private CopyAndSortList<Guest> copy = new CopyAndSortList<Guest>();

    public void add(Guest guest) {
        guestDao.add(guest);
    }

    @Override
    public Guest getGuestById(Integer id) {
        return guestDao.getGuestById(id);
    }

    public void getAll() {

        for (int i = 0; i < guestDao.getAll().size(); i++) {
            printer.print(guestDao.getAll().get(i));
        }

    }

    public void delete(Guest guest) {
        guestDao.delete(guest);
    }

    @Override
    public void getTotalNumberOfGuests() {
        printer.print(ServiceConstEnum.TOTAL_GUEST.getDescription());
        printer.print(guestDao.getAll().size());
    }

    @Override
    public void sortedGuestsBySurname() {
        printer.print(ServiceConstEnum.SORTED_GUEST_BY_SYRNAME);
        printer.print(copy.getCopiedAndSortedList(guestDao.getAll(), SURNAME_COMPARATOR));
    }

    @Override
    public void sortedGuestsByDateOfDeparture() {
        printer.print(ServiceConstEnum.SORTED_GUEST_BY_DATE_OF_DEPARTURE);
        printer.print(copy.getCopiedAndSortedList(guestDao.getAll(), DATE_OF_DEPARTURE_COMPARATOR));
    }

    @Override
    public void getServiceByGuest(Guest guest) {
        printer.print(guest.getRoom().getUsedServiceList());
    }

    @Override
    public List<Guest> getListGuests() {
        return guestDao.getAll();
    }
}
