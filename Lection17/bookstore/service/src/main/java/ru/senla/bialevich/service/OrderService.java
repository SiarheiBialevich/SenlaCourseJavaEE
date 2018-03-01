package ru.senla.bialevich.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.senla.bialevich.service.api.IOrderService;

@Service("orderService")
@Transactional
public class OrderService implements IOrderService {
}
