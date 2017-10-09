package ru.senla.bialevich.util.comparator.guestComparator;

import ru.senla.bialevich.entity.Guest;

import java.util.Comparator;

public class GuestDateOfDepartureComparator implements Comparator<Guest> {
    @Override
    public int compare(Guest o1, Guest o2) {
        if (o1.getOrder().getDateOfDeparture() == null) {
            return (o2.getOrder().getDateOfDeparture() == null) ? 0 : -1;
        } else
        if (o2.getOrder().getDateOfDeparture() == null) {
            return 1;
        }

        return o1.getOrder().getDateOfDeparture().compareTo(o2.getOrder().getDateOfArrival());
    }
}
