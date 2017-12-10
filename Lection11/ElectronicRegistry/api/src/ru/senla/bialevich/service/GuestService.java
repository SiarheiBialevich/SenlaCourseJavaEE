package ru.senla.bialevich.service;

import ru.senla.bialevich.dao.GuestDao;
import ru.senla.bialevich.entity.Guest;
import ru.senla.bialevich.entity.Registration;
import ru.senla.bialevich.entity.Room;
import ru.senla.bialevich.entity.Service;
import ru.senla.bialevich.enums.entity.SortType;

import java.util.List;

public interface GuestService {

    void addGuest(Guest guest);

    Guest getGuest(int id);

    void update(Guest guest);

    void delete(Guest guest);

    void addService(Guest guest, Service service);

    void removeService(Guest guest, Service service);

    List<Service> getServices(Guest guest, SortType type);

    List<Guest> getAll(SortType type);

    double getSumByRoom(Room room, Guest guest);

    int getCount();

    void setGuestDao(GuestDao guestDao);
}
