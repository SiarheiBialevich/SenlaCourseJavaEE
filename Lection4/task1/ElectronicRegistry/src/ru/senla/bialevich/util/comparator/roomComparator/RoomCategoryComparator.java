package ru.senla.bialevich.util.comparator.roomComparator;

import ru.senla.bialevich.entity.Room;

import java.util.Comparator;

public class RoomCategoryComparator implements Comparator<Room> {
    @Override
    public int compare(Room o1, Room o2) {
        if (o1.getCountStars() == null) {
            return (o2.getCountStars() == null) ? 0 : -1;
        }
        if (o2.getCountStars() == null) {
            return 1;
        }
        return o1.getCountStars().compareTo(o2.getCountStars());
    }
}
