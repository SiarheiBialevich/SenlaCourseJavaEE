package ru.senla.bialevich.util.comparator.roomComparator;

import ru.senla.bialevich.entity.Room;

import java.util.Comparator;

public class RoomCountBegsComparator implements Comparator<Room> {
    @Override
    public int compare(Room o1, Room o2) {
        return o1.getCountOfBeds().compareTo(o2.getCountOfBeds());
    }
}
