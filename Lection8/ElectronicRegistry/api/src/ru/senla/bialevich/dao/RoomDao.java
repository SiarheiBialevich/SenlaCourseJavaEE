package ru.senla.bialevich.dao;

import ru.senla.bialevich.entity.Guest;
import ru.senla.bialevich.entity.Room;
import ru.senla.bialevich.entity.UsedService;

import java.util.List;

public interface RoomDao extends AbstractDao<Room> {

    Room getRoomById(Integer id);

    void registerGuestInRoom(Guest guest, Room room);

    Integer getRoomIndexById(Integer id);

    void update(Room room);

    void setServiceToRoom(Room room, UsedService service);

    void setRoomList(List<Room> rooms);

}
