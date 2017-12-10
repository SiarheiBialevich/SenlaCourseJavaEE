package ru.senla.bialevich.service;

import ru.senla.bialevich.dao.GuestDao;
import ru.senla.bialevich.dao.RegistrationDao;
import ru.senla.bialevich.dao.RoomDao;
import ru.senla.bialevich.entity.Guest;
import ru.senla.bialevich.entity.Room;
import ru.senla.bialevich.entity.Service;
import ru.senla.bialevich.enums.entity.RoomSection;
import ru.senla.bialevich.enums.entity.SortType;

import java.util.Date;
import java.util.List;

public interface RoomService {

    void addRoom(Room room);

    Room getRoom(Integer id);

    void update(Room room);

    void delete(Room room);

    void registerGuest(Guest guest, Room room, Date startDate, Date finalDate);

    void evictGuest(Guest guest);

    Room cloneRoom(Integer id);

    List<Room> getAll(SortType type);

    //for free rooms
    List<Room> getAllFree(SortType type);

    int getCountFreeRooms();

    List<Room> getReleasedInFuture(Date date);

    List<Room> getLatestGuests(Integer count);

    List<Double> getPriceBySection(RoomSection section);

    void setRoomDao(RoomDao roomDao);

    void setGuestDao(GuestDao guestDao);

    void setRegistrationDao(RegistrationDao registrationDao);
}
