package ru.senla.bialevich.service;

import ru.senla.bialevich.api.dao.GuestDao;
import ru.senla.bialevich.api.service.GuestService;
import ru.senla.bialevich.dao.GuestDaoImpl;
import ru.senla.bialevich.entity.Guest;
import ru.senla.bialevich.util.Printer;
import ru.senla.bialevich.util.comparator.guestComparator.GuestDateOfDepartureComparator;
import ru.senla.bialevich.util.comparator.guestComparator.GuestSurnameComparator;

import java.util.ArrayList;
import java.util.List;

public class GuestServiceImpl implements GuestService {
    private GuestDao guestDao = new GuestDaoImpl();

    private GuestSurnameComparator surnameComparator = new GuestSurnameComparator();
    private GuestDateOfDepartureComparator dateOfDepartureComparator = new GuestDateOfDepartureComparator();

    private Printer printer = new Printer();

    private final String MESSAGE1 = "Total number of guests";
    private final String MESSAGE2 = "Sorted guest by surname";
    private final String MESSAGE3 = "Sorted guest by date of departure";

    public void add(Guest guest) {
        guestDao.add(guest);
    }

    public void getAll() {

        for (int i = 0; i < guestDao.getAll().size(); i++) {
            printer.printObject(guestDao.getAll().get(i));
        }

    }

    public void delete(Guest guest) {
        guestDao.delete(guest);
    }

    @Override
    public void getTotalNumberOfGuests() {
        printer.printMessage(MESSAGE1);
        printer.printObject(guestDao.getAll().size());
    }

    @Override
    public void sortedGuestBySurname() {
        printer.printMessage(MESSAGE2);

        ArrayList<Guest> roomsSorted = new ArrayList<Guest>(guestDao.getAll());
        roomsSorted.sort(surnameComparator);
        for (Guest guest : roomsSorted) {
            printer.printObject(guest);
        }
    }

    @Override
    public void sortedGuestByDateOfDeparture() {
        printer.printMessage(MESSAGE3);

        ArrayList<Guest> roomsSorted = new ArrayList<Guest>(guestDao.getAll());
        roomsSorted.sort(dateOfDepartureComparator);
        for (Guest guest : roomsSorted) {
            printer.printObject(guest);
        }
    }

    @Override
    public void getServiceByGuest(Guest guest) {
        printer.printObject(guest.getRoom().getUsedServiceList());
    }

    @Override
    public List<Guest> getListGuests() {
        return guestDao.getAll();
    }
}
