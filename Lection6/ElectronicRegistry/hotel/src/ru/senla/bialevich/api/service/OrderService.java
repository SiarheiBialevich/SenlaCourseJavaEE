package ru.senla.bialevich.api.service;

import ru.senla.bialevich.entity.Order;

import java.util.List;

public interface OrderService {

    void add(Order order);

    List<Order> getAll();

    Order getOrderById(Integer id);

    List<Order> getListOrders();

    void update(Order order);

    void setOrdersList(List<Order> orders);
}
