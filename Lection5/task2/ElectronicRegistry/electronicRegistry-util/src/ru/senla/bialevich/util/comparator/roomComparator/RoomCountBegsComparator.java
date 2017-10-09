package ru.senla.bialevich.util.comparator.roomComparator;

import ru.senla.bialevich.entity.Room;

import java.util.Comparator;

public class RoomCountBegsComparator implements Comparator<Room> {
    @Override
    public int compare(Room o1, Room o2) {
        if (o1.getCountOfBeds() == null) {
            return (o2.getCountOfBeds() == null) ? 0 : -1;
        }
        if (o2.getCountOfBeds() == null) {
            return 1;
        }
        return o1.getCountOfBeds().compareTo(o2.getCountOfBeds());
    }
}
