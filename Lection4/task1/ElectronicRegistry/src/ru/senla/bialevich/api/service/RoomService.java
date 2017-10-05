package ru.senla.bialevich.api.service;

import ru.senla.bialevich.entity.Room;

import java.util.List;

public interface RoomService {

    void add(Room room);

    List<Room> getFreeRooms();

    void sortedRoomsByPrice();

    void sortedRoomsByCountBegs();

    void sortedRoomsByCategory();

    void sortedFreeRoomsByPrice();

    void sortedFreeRoomsByCountBegs();

    void sortedFreeRoomsByCategory();

    void getTotalFreeNumberOfRooms();

    void getTotalPrice(Room room);

    void getAll();

    List<Room> getListRooms();
}
