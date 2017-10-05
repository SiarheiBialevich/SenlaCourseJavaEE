package ru.senla.bialevich.api.controller;

import ru.senla.bialevich.entity.*;

import java.util.List;

public interface ControllerHotel {

    void addGuest(Guest guest);

    void getAllGuest();

    void getTotalNumberOfGuests();

    void sortedGuestsBySurname();

    void sortedGuestsByDateOfDeparture();

    void getServiceByGuest(Guest guest);

    List<Guest> getListGuests();

    void addOrder(Order order);

    List<Order> getListOrders();

    void addRoom(Room room);

    void getFreeRooms();

    void sortedRoomsByPrice();

    void sortedRoomsByCountBegs();

    void sortedRoomsByCategory();

    void sortedFreeRoomsByPrice();

    void sortedFreeRoomsByCountBegs();

    void sortedFreeRoomsByCategory();

    void getTotalFreeNumberOfRooms();

    void getRoomTotalPrice(Room room);

    void getAllRooms();

    List<Room> getListRooms();

    void addUsedService(UsedService service);

    void sortUsedServicesByPrice();

    List<UsedService> getListUsedServices();
}
