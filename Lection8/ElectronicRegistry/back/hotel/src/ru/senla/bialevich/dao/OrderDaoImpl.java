package ru.senla.bialevich.dao;

import ru.senla.bialevich.entity.Order;

import java.util.List;

public class OrderDaoImpl extends AbstractDaoImpl<Order> implements OrderDao {

    private List<Order> orderModel;

    public OrderDaoImpl() {
        super(Order.class);
    }

    public OrderDaoImpl(List<Order> orders) {
        super(Order.class);
    }

    @Override
    public Order getOrderById(Integer id) {
        Order order = null;
        for (int i = 0; i < getTargetList().size(); i++) {
            if (getTargetList().get(i).getId().equals(id)) {
                order = getTargetList().get(i);
            }
        }

        return order;
    }

    public Integer getOrderIndexById(Integer id) {
        for (int i = 0; i < getTargetList().size(); i++) {
            if (getTargetList().get(i).getId() == id) {
                return i;
            }
        }

        return -1;
    }

    @Override
    List<Order> getTargetList() {
        return dataBase.getOrderList();
    }

    @Override
    public void setOrdersList(List<Order> orders) {
        dataBase.setOrderList(orders);
    }

    @Override
    public void update(Order order) {
        getTargetList().set(getOrderIndexById(order.getId()), order);
    }
}
