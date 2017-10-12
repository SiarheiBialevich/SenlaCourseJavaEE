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
    public List<Guest> getAllGuest() {
        return guestService.getAll();
    }

    @Override
    public Integer getTotalNumberOfGuests() {
        return guestService.getTotalNumberOfGuests();
    }

    @Override
    public List<Guest> sortedGuestsBySurname() {
        return guestService.sortedGuestsBySurname();
    }

    @Override
    public List<Guest> sortedGuestsByDateOfDeparture() {
        return guestService.sortedGuestsByDateOfDeparture();
    }

    @Override
    public List<UsedService> getServiceByGuest(Guest guest) {
        return guestService.getServiceByGuest(guest);
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
    public List<Room> getFreeRooms() {
        return roomService.getFreeRooms();
    }

    @Override
    public List<Room> sortedRoomsByPrice() {
        return roomService.sortedRoomsByPrice();
    }

    @Override
    public List<Room> sortedRoomsByCountBegs() {
        return roomService.sortedRoomsByCountBegs();
    }

    @Override
    public List<Room> sortedRoomsByCategory() {
        return roomService.sortedRoomsByCategory();
    }

    @Override
    public List<Room> sortedFreeRoomsByPrice() {
        return roomService.sortedFreeRoomsByPrice();
    }

    @Override
    public List<Room> sortedFreeRoomsByCountBegs() {
        return roomService.sortedFreeRoomsByCountBegs();
    }

    @Override
    public List<Room> sortedFreeRoomsByCategory() {
        return roomService.sortedFreeRoomsByCategory();
    }

    @Override
    public List<Room> getTotalFreeNumberOfRooms() {
        return roomService.getFreeRooms();
    }

    @Override
    public Float getRoomTotalPrice(Room room) {
        return roomService.getTotalPrice(room);
    }

    @Override
    public List<Room> getAllRooms() {
        return roomService.getAll();
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
    public List<UsedService> sortUsedServicesByPrice() {
        return usedService.sortUsedServicesByPrice();
    }

    @Override
    public List<UsedService> getListUsedServices() {
        return usedService.getListUsedServices();
    }

    @Override
    public Guest getGuestById(Integer id) {
        return guestService.getGuestById(id);
    }

    @Override
    public Room getRoomById(Integer id) {
        return roomService.getRoomById(id);
    }

    @Override
    public Order getOrderById(Integer id) {
        return orderService.getOrderById(id);
    }

    @Override
    public UsedService getServiceById(Integer id) {
        return usedService.getUsedServiceById(id);
    }
}
