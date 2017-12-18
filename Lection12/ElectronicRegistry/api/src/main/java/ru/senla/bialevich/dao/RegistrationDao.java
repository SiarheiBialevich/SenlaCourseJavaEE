package ru.senla.bialevich.dao;

import org.hibernate.Session;
import ru.senla.bialevich.model.Guest;
import ru.senla.bialevich.model.Registration;
import ru.senla.bialevich.model.Room;

import java.util.List;

public interface RegistrationDao extends AbstractDao<Registration> {

    List<Guest> getSortedByFinalDate(Session session);

    double getSumByRoom(Session session, Room room, Guest guest);
}
