package ru.senla.bialevich.util.comparator.guestComparator;

import ru.senla.bialevich.entity.Guest;

import java.util.Comparator;

public class GuestDateOfDepartureComparator implements Comparator<Guest> {
    @Override
    public int compare(Guest o1, Guest o2) {
        return o1.getOrder().getDateOfDeparture().compareTo(o2.getOrder().getDateOfDeparture());
    }
}
