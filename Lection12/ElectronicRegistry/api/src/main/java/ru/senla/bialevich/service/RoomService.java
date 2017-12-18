package ru.senla.bialevich.service;

import ru.senla.bialevich.dao.GuestDao;
import ru.senla.bialevich.dao.RegistrationDao;
import ru.senla.bialevich.dao.RoomDao;
import ru.senla.bialevich.enums.RoomSection;
import ru.senla.bialevich.enums.SortType;
import ru.senla.bialevich.model.Guest;
import ru.senla.bialevich.model.Room;

import java.util.Date;
import java.util.List;

public interface RoomService {

    void addRoom(Room room);

    Room getRoom(int id);

    void update(Room room);

    void delete(Room room);

    void registerGuest(Guest guest, Room room, Date startDate, Date finalDate);

    void evictGuest(Guest guest);

    Room cloneRoom(int id);

    List<Room> getAll(SortType type);

    //for free rooms
    List<Room> getAllFree(SortType type);

    int getCountFreeRooms();

    List<Room> getReleasedInFuture(Date date);

    List<Room> getLatestGuests(int count);

    List<Double> getPriceBySection(RoomSection section);
}
