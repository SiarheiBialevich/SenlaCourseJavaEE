package ru.senla.bialevich.util.wrapper;

import ru.senla.bialevich.entity.Guest;
import ru.senla.bialevich.entity.Order;
import ru.senla.bialevich.entity.Room;
import ru.senla.bialevich.entity.UsedService;

import java.io.Serializable;
import java.util.List;

public class Wrapper implements Serializable {
    private static final long serialVersionUID = -4477296293961152943L;

    private List<Guest> guests;
    private List<Room> rooms;
    private List<Order> orders;
    private List<UsedService> services;

    public Wrapper() {
    }

    public List<Guest> getGuests() {
        return guests;
    }

    public void setGuests(List<Guest> guests) {
        this.guests = guests;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public List<UsedService> getServices() {
        return services;
    }

    public void setServices(List<UsedService> services) {
        this.services = services;
    }
}
