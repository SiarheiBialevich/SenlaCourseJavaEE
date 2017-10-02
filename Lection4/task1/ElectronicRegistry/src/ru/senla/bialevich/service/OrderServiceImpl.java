package ru.senla.bialevich.service;

import ru.senla.bialevich.api.dao.OrderDao;
import ru.senla.bialevich.api.service.OrderService;
import ru.senla.bialevich.dao.OrderDaoImpl;
import ru.senla.bialevich.entity.Order;

import java.util.List;

public class OrderServiceImpl implements OrderService {
    private OrderDao orderDao = new OrderDaoImpl();

    @Override
    public void add(Order order) {
        orderDao.add(order);
    }

    @Override
    public List<Order> getListOrders() {
        return orderDao.getAll();
    }
}
