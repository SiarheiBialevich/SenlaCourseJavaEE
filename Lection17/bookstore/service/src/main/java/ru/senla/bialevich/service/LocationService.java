package ru.senla.bialevich.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.senla.bialevich.service.api.ILocationService;

@Service("locationService")
@Transactional
public class LocationService implements ILocationService {
}
