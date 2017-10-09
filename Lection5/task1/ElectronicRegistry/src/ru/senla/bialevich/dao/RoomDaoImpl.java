package ru.senla.bialevich.dao;

import ru.senla.bialevich.api.dao.RoomDao;
import ru.senla.bialevich.entity.Room;

import java.util.List;

public class RoomDaoImpl extends AbstractDaoImpl<Room> implements RoomDao {


    public RoomDaoImpl() {
        super(Room.class);
    }

    @Override
    public Room getRoomById(Integer id) {
        Room room = null;
        for (int i = 0; i < getTargetList().size(); i++) {
            if (getTargetList().get(i).getId().equals(id)) {
                room = getTargetList().get(i);
            }
        }

        return room;
    }

    @Override
    List<Room> getTargetList() {
        return dataBase.getRoomList();
    }


}