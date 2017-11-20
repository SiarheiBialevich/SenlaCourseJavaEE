package ru.senla.bialevich.service;

import org.apache.log4j.Logger;
import ru.senla.bialevich.dao.OrderDao;
import ru.senla.bialevich.dao.OrderDaoImpl;
import ru.senla.bialevich.entity.Order;

import java.util.List;

public class OrderServiceImpl implements OrderService {

    private static final Logger LOG = Logger.getLogger(OrderServiceImpl.class);
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
        synchronized (orderDao) {
            currentId = order.getId();
            order.setId(currentId++);
            orderDao.add(order);
            calcId();
        }
    }

    @Override
    public List<Order> getAll() {
        List<Order> orders = null;
        synchronized (orderDao) {
            try {
                orders = orderDao.getAll();
            } catch (Exception e) {
                LOG.error(e.getMessage());
            }
            return null;
        }
    }

    @Override
    public Order getOrderById(Integer id) {
        synchronized (orderDao) {
            return orderDao.getOrderById(id);
        }
    }

    @Override
    public List<Order> getListOrders() {
        synchronized (orderDao) {
            return orderDao.getAll();
        }
    }

    @Override
    public void update(Order order) {
        synchronized (orderDao) {
            orderDao.update(order);
        }
    }

    @Override
    public void setOrdersList(List<Order> orders) {
        synchronized (orderDao) {
            orderDao.setOrdersList(orders);
        }
    }
}
