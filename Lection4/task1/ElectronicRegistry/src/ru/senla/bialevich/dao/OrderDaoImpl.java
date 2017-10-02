package ru.senla.bialevich.dao;

import ru.senla.bialevich.api.dao.OrderDao;
import ru.senla.bialevich.entity.Order;

import java.util.List;

public class OrderDaoImpl extends AbstractDaoImpl<Order> implements OrderDao {

    public OrderDaoImpl() {
        super(Order.class);
    }

    @Override
    List<Order> getTargetList() {
        return dataBase.getOrderList();
    }
}
