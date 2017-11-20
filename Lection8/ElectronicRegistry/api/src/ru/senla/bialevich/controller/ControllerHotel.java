package ru.senla.bialevich.controller;

import ru.senla.bialevich.entity.Guest;
import ru.senla.bialevich.entity.Order;
import ru.senla.bialevich.entity.Room;
import ru.senla.bialevich.entity.UsedService;

import java.util.List;

public interface ControllerHotel {

    void init();

    void addGuest(Guest guest);

    List<Guest> getAllGuest();

    void updateGuest(Guest guest);

    Integer getTotalNumberOfGuests();

    List<Guest> sortedGuestsBySurname();

    List<Guest> sortedGuestsByDateOfDeparture();

    List<UsedService> getServiceByGuest(Guest guest);

    List<Guest> getListGuests();

    void setRoomToGuest(Guest guest, Room room);

    void setOrderToGuest(Guest guest, Order order);

    void addOrder(Order order);

    List<Order> getListOrders();

    void updateOrder(Order order);

    void addRoom(Room room);

    void registerGuestInRoom(Guest guest, Room room);

    void updateRoom(Room room);

    boolean changeRoomStatus(Room room);

    void changeRoomPrice(Room room, Float value);

    Room cloneRoom(Integer id);

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

    void updateService(UsedService service);

    List<UsedService> sortUsedServicesByPrice();

    List<UsedService> getListUsedServices();

    Guest getGuestById(Integer id);

    Room getRoomById(Integer id);

    Order getOrderById(Integer id);

    UsedService getServiceById(Integer id);

    void importGuests();

    void importOrder();

    void importRooms();

    //exports
    void exportGuests();

    void exportOrders();

    void exportRooms();

    void exportServices();

    void exportAll();

    String getProperty(String key);
}
