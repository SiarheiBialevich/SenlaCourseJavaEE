package ru.senla.bialevich.controller;

import ru.senla.bialevich.api.controller.ControllerHotel;
import ru.senla.bialevich.api.service.GuestService;
import ru.senla.bialevich.api.service.OrderService;
import ru.senla.bialevich.api.service.RoomService;
import ru.senla.bialevich.api.service.UsedServiceService;
import ru.senla.bialevich.entity.Guest;
import ru.senla.bialevich.entity.Order;
import ru.senla.bialevich.entity.Room;
import ru.senla.bialevich.entity.UsedService;
import ru.senla.bialevich.service.GuestServiceImpl;
import ru.senla.bialevich.service.OrderServiceImpl;
import ru.senla.bialevich.service.RoomServiceImpl;
import ru.senla.bialevich.service.UsedServiceServiceImpl;
import ru.senla.bialevich.util.Printer;

import java.util.List;

public class ControllerHotelImpl implements ControllerHotel {

    private GuestService guestService = new GuestServiceImpl();
    private OrderService orderService = new OrderServiceImpl();
    private RoomService roomService = new RoomServiceImpl();
    private UsedServiceService usedService = new UsedServiceServiceImpl();

    private Printer printer = new Printer();

    @Override
    public void addGuest(Guest guest) {
        guestService.add(guest);
    }

    @Override
    public void getAllGuest() {
        guestService.getAll();
    }

    @Override
    public void getTotalNumberOfGuests() {
        guestService.getTotalNumberOfGuests();
    }

    @Override
    public void sortedGuestsBySurname() {
        guestService.sortedGuestsBySurname();
    }

    @Override
    public void sortedGuestsByDateOfDeparture() {
        guestService.sortedGuestsByDateOfDeparture();
    }

    @Override
    public void getServiceByGuest(Guest guest) {
        guestService.getServiceByGuest(guest);
    }

    @Override
    public List<Guest> getListGuests() {
        return guestService.getListGuests();
    }

    @Override
    public void addOrder(Order order) {
        orderService.add(order);
    }

    @Override
    public List<Order> getListOrders() {
        return orderService.getListOrders();
    }

    @Override
    public void addRoom(Room room) {
        roomService.add(room);
    }

    @Override
    public void getFreeRooms() {
        roomService.getFreeRooms();
    }

    @Override
    public void sortedRoomsByPrice() {
        roomService.sortedRoomsByPrice();
    }

    @Override
    public void sortedRoomsByCountBegs() {
        roomService.sortedRoomsByCountBegs();
    }

    @Override
    public void sortedRoomsByCategory() {
        roomService.sortedRoomsByCategory();
    }

    @Override
    public void sortedFreeRoomsByPrice() {
        roomService.sortedFreeRoomsByPrice();
    }

    @Override
    public void sortedFreeRoomsByCountBegs() {
        roomService.sortedFreeRoomsByCountBegs();
    }

    @Override
    public void sortedFreeRoomsByCategory() {
        roomService.sortedFreeRoomsByCategory();
    }

    @Override
    public void getTotalFreeNumberOfRooms() {
        roomService.getFreeRooms();
    }

    @Override
    public void getRoomTotalPrice(Room room) {
        roomService.getTotalPrice(room);
    }

    @Override
    public void getAllRooms() {
        roomService.getAll();
    }

    @Override
    public List<Room> getListRooms() {
        return roomService.getListRooms();
    }

    @Override
    public void addUsedService(UsedService service) {
        usedService.add(service);
    }

    @Override
    public void sortUsedServicesByPrice() {
        usedService.sortUsedServicesByPrice();
    }

    @Override
    public List<UsedService> getListUsedServices() {
        return usedService.getListUsedServices();
    }
}
