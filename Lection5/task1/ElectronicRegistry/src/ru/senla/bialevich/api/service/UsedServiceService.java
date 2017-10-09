package ru.senla.bialevich.api.service;

import ru.senla.bialevich.entity.UsedService;

import java.util.List;

public interface UsedServiceService {

    void add(UsedService service);

    UsedService getUsedServiceById(Integer id);

    void sortUsedServicesByPrice();

    List<UsedService> getListUsedServices();
}
