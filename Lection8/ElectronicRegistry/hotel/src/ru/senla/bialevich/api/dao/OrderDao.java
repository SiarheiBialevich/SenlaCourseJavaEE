package ru.senla.bialevich.api.dao;

import ru.senla.bialevich.entity.Order;

import java.util.List;

public interface OrderDao extends AbstractDao<Order> {

    Order getOrderById(Integer id);

    Integer getOrderIndexById(Integer id);

    void update(Order order);

    void setOrdersList(List<Order> orders);
}
