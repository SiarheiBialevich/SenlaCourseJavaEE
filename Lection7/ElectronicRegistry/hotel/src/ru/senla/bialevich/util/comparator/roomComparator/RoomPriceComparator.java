package ru.senla.bialevich.util.comparator.roomComparator;

import ru.senla.bialevich.entity.Room;

import java.util.Comparator;

public class RoomPriceComparator implements Comparator<Room> {
    @Override
    public int compare(Room o1, Room o2) {
        if (o1.getPrice() == null) {
            return -1;
        } else if (o2.getPrice() == null) {
            return 1;
        } else if (o1.getPrice() == null && o2.getPrice() == null) {
            return 0;
        }
        return o1.getPrice().compareTo(o2.getPrice());
    }
}
