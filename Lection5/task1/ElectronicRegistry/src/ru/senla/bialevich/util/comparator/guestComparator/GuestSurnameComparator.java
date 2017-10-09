package ru.senla.bialevich.util.comparator.guestComparator;

import ru.senla.bialevich.entity.Guest;

import java.util.Comparator;

public class GuestSurnameComparator implements Comparator<Guest> {
    @Override
    public int compare(Guest o1, Guest o2) {
        if (o1.getSurname() == null) {
            return (o2.getSurname() == null) ? 0 : -1;
        }
        if (o2.getSurname() == null) {
            return 1;
        }
        return o1.getSurname().compareTo(o2.getSurname());
    }
}
