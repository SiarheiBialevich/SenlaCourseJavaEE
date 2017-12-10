package ru.senla.bialevich.api.service;

import ru.senla.bialevich.entity.Room;
import ru.senla.bialevich.entity.UsedService;

import java.util.List;

public interface RoomService {

    void add(Room room);

    Room getRoomById(Integer id);

    List<Room> getFreeRooms();

    List<Room> sortedRoomsByPrice();

    List<Room> sortedRoomsByCountBegs();

    List<Room> sortedRoomsByCategory();

    List<Room> sortedFreeRoomsByPrice();

    List<Room> sortedFreeRoomsByCountBegs();

    List<Room> sortedFreeRoomsByCategory();

    Integer getTotalFreeNumberOfRooms();

    Float getTotalPrice(Room room);

    List<Room> getAll();

    List<Room> getListRooms();

    void setServiceToRoom(Room room, UsedService service);
}
