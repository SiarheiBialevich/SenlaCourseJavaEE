package ru.senla.bialevich.database;

import ru.senla.bialevich.entity.Guest;
import ru.senla.bialevich.entity.Order;
import ru.senla.bialevich.entity.Room;
import ru.senla.bialevich.entity.UsedService;

import java.util.ArrayList;
import java.util.List;

public class DataBase {

    private static DataBase dataBase;

    private List<Guest> guestList = new ArrayList<Guest>();
    private List<Room> roomList = new ArrayList<Room>();
    private List<Order> orderList = new ArrayList<Order>();
    private List<UsedService> usedServiceList = new ArrayList<UsedService>();

    private DataBase() {
    }

    public static DataBase getDataBase() {
        if (dataBase == null) {

            dataBase = new DataBase();
        }

        return dataBase;
    }

    public List<Guest> getGuestList() {
        return guestList;
    }

    public List<Room> getRoomList() {
        return roomList;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public List<UsedService> getUsedServiceList() {
        return usedServiceList;
    }

    public void setGuestList(List<Guest> guestList) {
        this.guestList = guestList;
    }

    public void setRoomList(List<Room> roomList) {
        this.roomList = roomList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public void setUsedServiceList(List<UsedService> usedServiceList) {
        this.usedServiceList = usedServiceList;
    }
}
