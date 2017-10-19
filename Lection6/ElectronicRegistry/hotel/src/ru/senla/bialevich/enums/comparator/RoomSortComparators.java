package ru.senla.bialevich.enums.comparator;

import ru.senla.bialevich.entity.Room;
import ru.senla.bialevich.util.comparator.roomComparator.RoomCategoryComparator;
import ru.senla.bialevich.util.comparator.roomComparator.RoomCountBegsComparator;
import ru.senla.bialevich.util.comparator.roomComparator.RoomPriceComparator;

import java.util.Comparator;

public enum  RoomSortComparators {
    ROOM_CAREGORY(new RoomCategoryComparator()),
    ROOM_COUNT_BEGS(new RoomCountBegsComparator()),
    ROOM_PRICE(new RoomPriceComparator());

    private Comparator<Room> roomComparator;

    private RoomSortComparators(Comparator<Room> roomComparator) {
        this.roomComparator = roomComparator;
    }

    public Comparator<Room> getRoomComparator() {
        return roomComparator;
    }
}
