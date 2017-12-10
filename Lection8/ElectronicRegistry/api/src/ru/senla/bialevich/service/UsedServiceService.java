package ru.senla.bialevich.service;

import ru.senla.bialevich.entity.UsedService;

import java.util.List;

public interface UsedServiceService {

    void add(UsedService service);

    List<UsedService> getAll();

    UsedService getUsedServiceById(Integer id);

    List<UsedService> sortUsedServicesByPrice();

    List<UsedService> getListUsedServices();

    void update(UsedService service);

    void setServicesList(List<UsedService> services);
}
