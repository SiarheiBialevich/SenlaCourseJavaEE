package ru.senla.bialevich.service;

import ru.senla.bialevich.api.dao.RoomDao;
import ru.senla.bialevich.api.service.RoomService;
import ru.senla.bialevich.dao.RoomDaoImpl;
import ru.senla.bialevich.entity.Room;
import ru.senla.bialevich.enums.RoomSortComparators;
import ru.senla.bialevich.util.CopyAndSortList;

import java.util.ArrayList;
import java.util.List;

public class RoomServiceImpl implements RoomService {
    private CopyAndSortList<Room> copy = new CopyAndSortList<Room>();

    private RoomDao roomDao = new RoomDaoImpl();


    public void add(Room room) {
        roomDao.add(room);
    }

    @Override
    public Room getRoomById(Integer id) {
        return roomDao.getRoomById(id);
    }

    @Override
    public List<Room> getFreeRooms() {

        List<Room> rooms = new ArrayList<>();
        for (int i = 0; i < roomDao.getAll().size(); i++) {
            if (roomDao.getAll().get(i).isFree()) {
                rooms.add(roomDao.getAll().get(i));
            }
        }

        return rooms;
    }

    @Override
    public List<Room> sortedRoomsByPrice() {

        return copy.getCopiedAndSortedList(roomDao.getAll(), RoomSortComparators.ROOM_PRICE.getRoomComparator());
    }

    @Override
    public List<Room> sortedRoomsByCountBegs() {

        return copy.getCopiedAndSortedList(roomDao.getAll(), RoomSortComparators.ROOM_COUNT_BEGS.getRoomComparator());
    }

    @Override
    public List<Room> sortedRoomsByCategory() {
        return copy.getCopiedAndSortedList(roomDao.getAll(), RoomSortComparators.ROOM_CAREGORY.getRoomComparator());
    }

    @Override
    public List<Room> sortedFreeRoomsByPrice() {

        return copy.getCopiedAndSortedList(getFreeRooms(), RoomSortComparators.ROOM_PRICE.getRoomComparator());
    }

    @Override
    public List<Room> sortedFreeRoomsByCountBegs() {

        return copy.getCopiedAndSortedList(getFreeRooms(), RoomSortComparators.ROOM_COUNT_BEGS.getRoomComparator());
    }

    @Override
    public List<Room> sortedFreeRoomsByCategory() {

        return copy.getCopiedAndSortedList(getFreeRooms(), RoomSortComparators.ROOM_CAREGORY.getRoomComparator());
    }

    @Override
    public Integer getTotalFreeNumberOfRooms() {

        return getFreeRooms().size();
    }

    @Override
    public Float getTotalPrice(Room room) {
        return room.getPrice();
    }

    @Override
    public List<Room> getAll() {

        return roomDao.getAll();
    }

    @Override
    public List<Room> getListRooms() {
        return roomDao.getAll();
    }
}
