package ru.senla.bialevich.service;

import ru.senla.bialevich.api.dao.GuestDao;
import ru.senla.bialevich.api.dao.OrderDao;
import ru.senla.bialevich.api.dao.RoomDao;
import ru.senla.bialevich.api.service.RoomService;
import ru.senla.bialevich.dao.RoomDaoImpl;
import ru.senla.bialevich.entity.Guest;
import ru.senla.bialevich.entity.Room;
import ru.senla.bialevich.entity.UsedService;
import ru.senla.bialevich.enums.comparator.RoomSortComparators;
import ru.senla.bialevich.util.CopyAndSortList;

import java.util.ArrayList;
import java.util.List;

public class RoomServiceImpl implements RoomService {
    private CopyAndSortList<Room> copy = new CopyAndSortList<Room>();

    private RoomDao roomDao = new RoomDaoImpl();

    private Integer currentId = 1;

    private void calcId() {
        Integer maxId = 0;
        for (Room room :roomDao.getAll()) {
            if (room.getId() > maxId) {
                maxId = room.getId();
            }
        }
        currentId = maxId + 1;
    }


    public void add(Room room) {
        synchronized (roomDao) {
            currentId = room.getId();
            room.setId(currentId++);
            roomDao.add(room);
            calcId();
        }
    }

    @Override
    public void registerGuestInRoom(Guest guest, Room room) {
        synchronized (roomDao) {
            roomDao.registerGuestInRoom(guest, room);
        }
    }

    public Room cloneRoom(Integer id) {
        synchronized (roomDao) {
            Room room = roomDao.getRoomById(id);
            Room clone = null;

            try {
                clone = (Room) room.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }

            return clone;
        }
    }

    @Override
    public void update(Room room) {
        synchronized (roomDao) {
            roomDao.update(room);
        }
    }

    @Override
    public Room getRoomById(Integer id) {
        synchronized (roomDao) {
            return roomDao.getRoomById(id);
        }
    }

    @Override
    public List<Room> getFreeRooms() {
        synchronized (roomDao) {
            List<Room> rooms = new ArrayList<>();
            for (int i = 0; i < roomDao.getAll().size(); i++) {
                if (roomDao.getAll().get(i).isFree()) {
                    rooms.add(roomDao.getAll().get(i));
                }
            }

            return rooms;
        }
    }

    @Override
    public List<Room> sortedRoomsByPrice() {
        synchronized (roomDao) {
            return copy.getCopiedAndSortedList(roomDao.getAll(), RoomSortComparators.ROOM_PRICE.getRoomComparator());
        }
    }

    @Override
    public List<Room> sortedRoomsByCountBegs() {
        synchronized (roomDao) {
            return copy.getCopiedAndSortedList(roomDao.getAll(), RoomSortComparators.ROOM_COUNT_BEGS.getRoomComparator());
        }
    }

    @Override
    public List<Room> sortedRoomsByCategory() {
        synchronized (roomDao) {
            return copy.getCopiedAndSortedList(roomDao.getAll(), RoomSortComparators.ROOM_CAREGORY.getRoomComparator());
        }
    }

    @Override
    public List<Room> sortedFreeRoomsByPrice() {
        synchronized (roomDao) {
            return copy.getCopiedAndSortedList(getFreeRooms(), RoomSortComparators.ROOM_PRICE.getRoomComparator());
        }
    }

    @Override
    public List<Room> sortedFreeRoomsByCountBegs() {
        synchronized (roomDao) {
            return copy.getCopiedAndSortedList(getFreeRooms(), RoomSortComparators.ROOM_COUNT_BEGS.getRoomComparator());
        }
    }

    @Override
    public List<Room> sortedFreeRoomsByCategory() {
        synchronized (roomDao) {
            return copy.getCopiedAndSortedList(getFreeRooms(), RoomSortComparators.ROOM_CAREGORY.getRoomComparator());
        }
    }

    @Override
    public Integer getTotalFreeNumberOfRooms() {
        synchronized (roomDao) {
            return getFreeRooms().size();
        }
    }

    @Override
    public Float getTotalPrice(Room room) {
        synchronized (roomDao) {
            return room.getPrice();
        }
    }

    @Override
    public List<Room> getAll() {
        synchronized (roomDao) {
            return roomDao.getAll();
        }
    }

    @Override
    public List<Room> getListRooms() {
        synchronized (roomDao) {
            return roomDao.getAll();
        }
    }

    @Override
    public void setServiceToRoom(Room room, UsedService service) {
        synchronized (roomDao) {
            roomDao.setServiceToRoom(room, service);
        }
    }

    @Override
    public void setRoomList(List<Room> rooms) {
        synchronized (roomDao) {
            roomDao.setRoomList(rooms);
        }
    }
}
