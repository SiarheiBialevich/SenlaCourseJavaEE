package ru.senla.bialevich.service;

import org.apache.log4j.Logger;
import ru.senla.bialevich.api.dao.OrderDao;
import ru.senla.bialevich.api.service.OrderService;
import ru.senla.bialevich.dao.OrderDaoImpl;
import ru.senla.bialevich.entity.Order;

import java.util.List;

public class OrderServiceImpl implements OrderService {

    private static final Logger LOG = Logger.getLogger(OrderServiceImpl.class);
    private OrderDao orderDao = new OrderDaoImpl();

    public OrderServiceImpl(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public OrderServiceImpl() {
    }

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
        currentId = order.getId();
        order.setId(currentId++);
        orderDao.add(order);
        calcId();
    }

    @Override
    public List<Order> getAll() {
        List<Order> orders = null;
        try {
            orders = orderDao.getAll();
        } catch (Exception e) {
            LOG.error(e.getMessage());
        }
        return null;
    }

    @Override
    public Order getOrderById(Integer id) {
        return orderDao.getOrderById(id);
    }

    @Override
    public List<Order> getListOrders() {
        return orderDao.getAll();
    }

    @Override
    public void update(Order order) {
        orderDao.update(order);
    }

    @Override
    public void setOrdersList(List<Order> orders) {
        orderDao.setOrdersList(orders);
    }
}
