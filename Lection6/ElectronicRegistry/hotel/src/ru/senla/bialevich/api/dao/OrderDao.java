package ru.senla.bialevich.api.dao;

import ru.senla.bialevich.entity.Order;

public interface OrderDao extends AbstractDao<Order> {

    Order getOrderById(Integer id);
}
