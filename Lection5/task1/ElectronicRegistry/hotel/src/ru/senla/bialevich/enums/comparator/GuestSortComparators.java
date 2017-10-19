package ru.senla.bialevich.enums.comparator;

import ru.senla.bialevich.entity.Guest;
import ru.senla.bialevich.util.comparator.guestComparator.GuestDateOfDepartureComparator;
import ru.senla.bialevich.util.comparator.guestComparator.GuestSurnameComparator;

import java.util.Comparator;

public enum GuestSortComparators {
    SURNAME(new GuestSurnameComparator()),
    DATE_OF_DEPARTURE(new GuestDateOfDepartureComparator());

    private Comparator<Guest> guestComparator;

    private GuestSortComparators(Comparator<Guest> guestComparator) {
        this.guestComparator = guestComparator;
    }

    public Comparator<Guest> getGuestComparator() {
        return guestComparator;
    }
}
