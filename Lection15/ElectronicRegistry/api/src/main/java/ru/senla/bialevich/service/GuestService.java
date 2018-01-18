package ru.senla.bialevich.service;

import ru.senla.bialevich.dao.GuestDao;
import ru.senla.bialevich.enums.SortType;
import ru.senla.bialevich.model.Guest;
import ru.senla.bialevich.model.Room;
import ru.senla.bialevich.model.Service;

import java.util.List;

public interface GuestService {

    void addGuest(Guest guest);

    Guest getGuest(int id);

    void update(Guest guest);

    void delete(Guest guest);

    List<Guest> getAll(SortType type);

    int getCount();
}
