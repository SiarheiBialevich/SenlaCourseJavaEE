package ru.senla.bialevich.api;

import ru.senla.bialevich.entity.Room;
import ru.senla.bialevich.entity.UsedService;

import java.util.List;

public interface RoomMenuController {

    void addRoom(Room room);

    List<Room> getFreeRooms();

    List<Room> getTotalFreeNumberOfRooms();

    Float getRoomTotalPrice(Room room);

    List<Room> getAllRooms();

    List<Room> sortedRoomsByPrice();

    List<Room> sortedRoomsByCountBegs();

    List<Room> sortedRoomsByCategory();

    List<Room> sortedFreeRoomsByPrice();

    List<Room> sortedFreeRoomsByCountBegs();

    List<Room> sortedFreeRoomsByCategory();

    void addServiceToTheRoom(Room room, UsedService service);

    Room getRoomById(Integer id);

    void writeToFile(String filePath, List<Room> rooms);

    List<Room> readFromFile(String filePath);
}
