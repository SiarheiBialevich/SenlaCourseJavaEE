package ru.senla.bialevich.service;

import ru.senla.bialevich.dao.ServiceDao;
import ru.senla.bialevich.entity.Service;
import ru.senla.bialevich.enums.entity.ServicesSection;
import ru.senla.bialevich.enums.entity.SortType;

import java.util.List;

public interface ServiceService {

    void addService(Service service);

    Service getService(Integer id);

    void update(Service service);

    void delete(Service service);

    List<Service> getAll(SortType type);

    List<Double> getPricesBySection(ServicesSection section);

    void setServiceDao(ServiceDao serviceDao);
}
