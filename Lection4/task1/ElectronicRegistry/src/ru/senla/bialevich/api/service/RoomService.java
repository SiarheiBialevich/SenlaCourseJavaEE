package ru.senla.bialevich.api.service;

import ru.senla.bialevich.entity.Room;

import java.util.List;

public interface RoomService {

    void add(Room room);

    List<Room> getFreeRooms();

    void sortedRoomByPrice();

    void sortedRoomByCountBegs();

    void sortedRoomByCategory();

    void sortedFreeRoomsByPrice();

    void sortedFreeRoomsByCountBegs();

    void sortedRoomsByCategory();

    void getTotalFreeNumberOfRooms();

    void getTotalPrice(Room room);

    void getAll();

    List<Room> getListRooms();
}
