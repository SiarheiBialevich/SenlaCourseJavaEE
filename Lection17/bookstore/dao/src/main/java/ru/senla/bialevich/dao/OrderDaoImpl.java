package ru.senla.bialevich.dao;

import org.springframework.stereotype.Repository;
import ru.senla.bialevich.dao.api.IOrderDao;
import ru.senla.bialevich.entity.Order;

@Repository("orderDaoImpl")
public class OrderDaoImpl extends AbstractDaoImpl<Order> implements IOrderDao {
}
