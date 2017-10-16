package ru.senla.bialevich.api.controller;

import ru.senla.bialevich.entity.*;

import java.util.List;

public interface ControllerHotel {

    void addGuest(Guest guest);

    List<Guest> getAllGuest();

    Integer getTotalNumberOfGuests();

    List<Guest> sortedGuestsBySurname();

    List<Guest> sortedGuestsByDateOfDeparture();

    List<UsedService> getServiceByGuest(Guest guest);

    List<Guest> getListGuests();

    void setRoomToGuest(Guest guest, Room room);

    void setOrderToGuest(Guest guest, Order order);

    void addOrder(Order order);

    List<Order> getListOrders();

    void addRoom(Room room);

    List<Room> getFreeRooms();

    List<Room> sortedRoomsByPrice();

    List<Room> sortedRoomsByCountBegs();

    List<Room> sortedRoomsByCategory();

    List<Room> sortedFreeRoomsByPrice();

    List<Room> sortedFreeRoomsByCountBegs();

    List<Room> sortedFreeRoomsByCategory();

    List<Room> getTotalFreeNumberOfRooms();

    Float getRoomTotalPrice(Room room);

    List<Room> getAllRooms();

    List<Room> getListRooms();

    void setServiceToRoom(Room room, UsedService service);

    void addUsedService(UsedService service);

    List<UsedService> sortUsedServicesByPrice();

    List<UsedService> getListUsedServices();

    Guest getGuestById(Integer id);

    Room getRoomById(Integer id);

    Order getOrderById(Integer id);

    UsedService getServiceById(Integer id);
}
