package ru.senla.bialevich.dao;

import ru.senla.bialevich.api.dao.RoomDao;
import ru.senla.bialevich.entity.Room;

import java.util.List;

public class RoomDaoImpl extends AbstractDaoImpl<Room> implements RoomDao {


    public RoomDaoImpl() {
        super(Room.class);
    }

    @Override
    List<Room> getTargetList() {
        return dataBase.getRoomList();
    }


}
