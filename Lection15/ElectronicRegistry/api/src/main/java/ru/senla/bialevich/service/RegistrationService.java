package ru.senla.bialevich.service;

import ru.senla.bialevich.dao.RegistrationDao;
import ru.senla.bialevich.model.Guest;
import ru.senla.bialevich.model.Registration;
import ru.senla.bialevich.enums.SortType;
import ru.senla.bialevich.model.Room;

import java.util.List;

public interface RegistrationService {

    void addRecord(Registration registration);

    void update(Registration registration);

    List<Guest> getSortedByFinalDate();

    double getSumByRoom(Room room, Guest guest);

    Registration getRegistration(int id);

    List<Registration> getAll(SortType type);
}
