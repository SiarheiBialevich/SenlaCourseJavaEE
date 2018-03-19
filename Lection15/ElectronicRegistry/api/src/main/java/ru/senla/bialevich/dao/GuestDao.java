package ru.senla.bialevich.dao;

import org.hibernate.Session;
import ru.senla.bialevich.model.Guest;
import ru.senla.bialevich.model.Room;
import ru.senla.bialevich.model.Service;
import ru.senla.bialevich.enums.SortType;

import java.sql.Connection;
import java.util.List;

public interface GuestDao extends AbstractDao<Guest> {

    Integer getCount(Session session);

}
