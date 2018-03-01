package ru.senla.bialevich.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.senla.bialevich.service.api.ICityService;

@Service("cityService")
@Transactional
public class CityService implements ICityService {
}
