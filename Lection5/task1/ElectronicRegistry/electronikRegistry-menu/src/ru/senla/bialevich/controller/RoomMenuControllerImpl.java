package ru.senla.bialevich.controller;

import ru.senla.bialevich.api.RoomMenuController;
import ru.senla.bialevich.api.controller.ControllerHotel;
import ru.senla.bialevich.entity.Room;
import ru.senla.bialevich.entity.UsedService;

import java.util.List;

public class RoomMenuControllerImpl implements RoomMenuController {
    private ControllerHotel hotel = new ControllerHotelImpl();

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
}
