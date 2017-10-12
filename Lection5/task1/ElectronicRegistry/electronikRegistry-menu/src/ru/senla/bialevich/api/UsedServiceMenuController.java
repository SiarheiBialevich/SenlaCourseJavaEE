package ru.senla.bialevich.api;

import ru.senla.bialevich.entity.UsedService;

import java.util.List;

public interface UsedServiceMenuController {

    void addUsedService(UsedService service);

    List<UsedService> sortUsedServicesByPrice();

    List<UsedService> getListUsedServices();
}
