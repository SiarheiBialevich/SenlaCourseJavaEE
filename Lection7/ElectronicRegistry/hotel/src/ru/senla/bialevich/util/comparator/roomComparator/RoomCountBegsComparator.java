package ru.senla.bialevich.util.comparator.roomComparator;

import ru.senla.bialevich.entity.Room;

import java.util.Comparator;

public class RoomCountBegsComparator implements Comparator<Room> {
    @Override
    public int compare(Room o1, Room o2) {
        if (o1.getCapacity() == null) {
            return -1;
        } else if (o2.getCapacity() == null) {
            return 1;
        } else if (o1.getCapacity() == null && o2.getCapacity() == null) {
            return 0;
        }
        return o1.getCapacity().compareTo(o2.getCapacity());
    }
}
