package ru.senla.bialevich.controller;

import ru.senla.bialevich.api.OrderMenuController;
import ru.senla.bialevich.api.controller.ControllerHotel;
import ru.senla.bialevich.entity.Order;

import java.util.List;

public class OrderMenuControllerImpl implements OrderMenuController {
    private ControllerHotel hotel = new ControllerHotelImpl();

    @Override
    public void addOrder(Order order) {
        hotel.addOrder(order);
    }

    @Override
    public List<Order> getListOrders() {
        return hotel.getListOrders();
    }
}
