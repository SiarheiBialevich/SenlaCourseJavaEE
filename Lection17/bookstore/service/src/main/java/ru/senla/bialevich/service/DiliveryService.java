package ru.senla.bialevich.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.senla.bialevich.service.api.IDiliveryService;

@Service("diliveryService")
@Transactional
public class DiliveryService implements IDiliveryService {
}
