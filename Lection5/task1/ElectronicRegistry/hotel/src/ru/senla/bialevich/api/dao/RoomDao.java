package ru.senla.bialevich.api.dao;

import ru.senla.bialevich.entity.Room;
import ru.senla.bialevich.entity.UsedService;

public interface RoomDao extends AbstractDao<Room> {

    Room getRoomById(Integer id);

    void setServiceToRoom(Room room, UsedService service);

}
