package ru.senla.bialevich.api.service;

import ru.senla.bialevich.entity.Order;

import java.util.List;

public interface OrderService {

    void add(Order order);

    Order getOrderById(Integer id);

    List<Order> getListOrders();
}
