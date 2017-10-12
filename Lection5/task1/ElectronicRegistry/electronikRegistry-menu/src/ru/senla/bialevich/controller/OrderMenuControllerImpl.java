package ru.senla.bialevich.controller;

import ru.senla.bialevich.api.OrderMenuController;
import ru.senla.bialevich.api.controller.ControllerHotel;
import ru.senla.bialevich.entity.Order;
import ru.senla.bialevich.util.WriteToFile;

import java.util.List;

public class OrderMenuControllerImpl implements OrderMenuController {
    private ControllerHotel hotel = new ControllerHotelImpl();
    private WriteToFile writeToFile = new WriteToFile();

    @Override
    public void addOrder(Order order) {
        hotel.addOrder(order);
    }

    @Override
    public List<Order> getListOrders() {
        return hotel.getListOrders();
    }

    @Override
    public Order getOrderById(Integer id) {
        return hotel.getOrderById(id);
    }

    @Override
    public void writeToFife(String filePath, List<Order> orders) {
        writeToFile.write(filePath, orders);
    }
}
