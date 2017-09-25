package ru.senla.bialevich.util.comparator.roomComparator;

import ru.senla.bialevich.Entity.Room;

import java.util.Comparator;

public class RoomCategoryComparator implements Comparator<Room> {
    @Override
    public int compare(Room o1, Room o2) {
        return o1.getCountStars().compareTo(o2.getCountStars());
    }
}
