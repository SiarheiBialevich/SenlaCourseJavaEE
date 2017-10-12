package ru.senla.bialevich.api;

import ru.senla.bialevich.entity.Order;

import java.util.List;

public interface OrderMenuController {

    void addOrder(Order order);

    List<Order> getListOrders();

    Order getOrderById(Integer id);

    void writeToFife(String filePath, List<Order> orders);
}
