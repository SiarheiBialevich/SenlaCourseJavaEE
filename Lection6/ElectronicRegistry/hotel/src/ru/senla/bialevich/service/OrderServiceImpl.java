package ru.senla.bialevich.service;

import ru.senla.bialevich.api.dao.OrderDao;
import ru.senla.bialevich.api.service.OrderService;
import ru.senla.bialevich.dao.OrderDaoImpl;
import ru.senla.bialevich.entity.Order;

import java.util.List;

public class OrderServiceImpl implements OrderService {
    private OrderDao orderDao = new OrderDaoImpl();

    private Integer currentId = 1;

    private void calcId() {
        Integer maxId = 0;

        for (Order order :orderDao.getAll()) {
            if (order.getId() > maxId) {
                maxId = order.getId();
            }
        }
        currentId = maxId + 1;
    }

    @Override
    public void add(Order order) {
        order.setId(currentId++);
        orderDao.add(order);
        calcId();
    }

    @Override
    public Order getOrderById(Integer id) {
        return orderDao.getOrderById(id);
    }

    @Override
    public List<Order> getListOrders() {
        return orderDao.getAll();
    }
}
