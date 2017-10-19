package ru.senla.bialevich.api.dao;

import ru.senla.bialevich.entity.Room;
import ru.senla.bialevich.entity.UsedService;

public interface RoomDao extends AbstractDao<Room> {

    Room getRoomById(Integer id);

    Integer getRoomIndexById(Integer id);

    void update(Room room);

    void setServiceToRoom(Room room, UsedService service);

}
