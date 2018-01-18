package ru.senla.bialevich.dao;

import org.hibernate.Session;
import ru.senla.bialevich.model.Room;
import ru.senla.bialevich.enums.RoomSection;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

public interface RoomDao extends AbstractDao<Room> {

    Integer getCountFreeRooms(Session session);

    List<Room> getLatestGuests(Session session, Integer count);

    List<Room> getReleasedInFuture(Session session, Date date);

    List<Double> getPriceBySection(Session session, RoomSection section);


}
