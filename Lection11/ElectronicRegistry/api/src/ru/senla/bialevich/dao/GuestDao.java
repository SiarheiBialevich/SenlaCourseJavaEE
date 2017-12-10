package ru.senla.bialevich.dao;

import ru.senla.bialevich.entity.Guest;
import ru.senla.bialevich.entity.Room;
import ru.senla.bialevich.entity.Service;
import ru.senla.bialevich.enums.entity.SortType;

import java.sql.Connection;
import java.util.List;

public interface GuestDao extends AbstractDao<Guest> {

    List<Service> getServices(Guest guest, SortType type, Connection connection);

    List<Guest> getSortedByFinalDate(Connection connection);

    double getSumByRoom(Room room, Guest guest, Connection connection);

    Integer getCount(Connection connection);

}
