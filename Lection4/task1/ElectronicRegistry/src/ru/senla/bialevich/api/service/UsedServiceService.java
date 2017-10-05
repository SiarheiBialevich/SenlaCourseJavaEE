package ru.senla.bialevich.api.service;

import ru.senla.bialevich.entity.UsedService;

import java.util.List;

public interface UsedServiceService {
    void add(UsedService service);

    void sortUsedServicesByPrice();

    List<UsedService> getListUsedServices();
}
