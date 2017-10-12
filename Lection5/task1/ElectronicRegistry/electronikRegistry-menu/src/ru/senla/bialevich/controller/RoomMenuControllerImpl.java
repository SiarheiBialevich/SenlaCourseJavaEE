package ru.senla.bialevich.controller;

import ru.senla.bialevich.api.RoomMenuController;
import ru.senla.bialevich.api.controller.ControllerHotel;
import ru.senla.bialevich.entity.Room;
import ru.senla.bialevich.entity.UsedService;
import ru.senla.bialevich.util.ReadRoomFromFile;
import ru.senla.bialevich.util.WriteToFile;

import java.util.List;

public class RoomMenuControllerImpl implements RoomMenuController {
    private ControllerHotel hotel = new ControllerHotelImpl();
    private WriteToFile writeToFile = new WriteToFile();
    private ReadRoomFromFile readRoomFromFile = new ReadRoomFromFile();

    @Override
    public void addRoom(Room room) {
        hotel.addRoom(room);
    }

    @Override
    public List<Room> getFreeRooms() {
        return hotel.getFreeRooms();
    }

    @Override
    public List<Room> getTotalFreeNumberOfRooms() {
        return hotel.getTotalFreeNumberOfRooms();
    }

    @Override
    public Float getRoomTotalPrice(Room room) {
        return hotel.getRoomTotalPrice(room);
    }

    @Override
    public List<Room> getAllRooms() {
        return hotel.getAllRooms();
    }

    @Override
    public List<Room> sortedRoomsByPrice() {
        return hotel.sortedRoomsByPrice();
    }

    @Override
    public List<Room> sortedRoomsByCountBegs() {
        return hotel.sortedRoomsByCountBegs();
    }

    @Override
    public List<Room> sortedRoomsByCategory() {
        return hotel.sortedRoomsByCategory();
    }

    @Override
    public List<Room> sortedFreeRoomsByPrice() {
        return hotel.sortedFreeRoomsByPrice();
    }

    @Override
    public List<Room> sortedFreeRoomsByCountBegs() {
        return hotel.sortedFreeRoomsByCountBegs();
    }

    @Override
    public List<Room> sortedFreeRoomsByCategory() {
        return hotel.sortedFreeRoomsByCategory();
    }

    @Override
    public void addServiceToTheRoom(Room room, UsedService service) {
        room.addService(service);
    }

    @Override
    public Room getRoomById(Integer id) {
        return hotel.getRoomById(id);
    }

    @Override
    public void writeToFile(String filePath, List<Room> rooms) {
        writeToFile.write(filePath, rooms);
    }

    @Override
    public List<Room> readFromFile(String filePath) {
        return readFromFile(filePath);
    }
}
