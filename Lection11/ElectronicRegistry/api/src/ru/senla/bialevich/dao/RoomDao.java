package ru.senla.bialevich.dao;

import ru.senla.bialevich.entity.Room;
import ru.senla.bialevich.enums.entity.RoomSection;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

public interface RoomDao extends AbstractDao<Room> {

    Integer getCountFreeRoom(Connection connection);

    List<Room> getLatestGuest(Integer count, Connection connection);

    List<Room> getReleasedInFuture(Date date, Connection connection);

    List<Double> getPriceBySection(RoomSection section, Connection connection);


}
