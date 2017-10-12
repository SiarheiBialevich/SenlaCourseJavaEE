package ru.senla.bialevich.util.comparator.guestComparator;

import ru.senla.bialevich.entity.Guest;

import java.util.Comparator;

public class GuestSurnameComparator implements Comparator<Guest> {
    @Override
    public int compare(Guest o1, Guest o2) {
        if (o1.getSurname() == null) {
            return -1;
        } else if (o2.getSurname() == null) {
            return 1;
        } else if (o1.getSurname() == null && o2.getSurname() == null) {
            return 0;
        }
        return o1.getSurname().compareTo(o2.getSurname());
    }
}
