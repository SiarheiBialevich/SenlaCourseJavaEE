package ru.senla.bialevich.service;

import ru.senla.bialevich.dao.ServiceDao;
import ru.senla.bialevich.model.Guest;
import ru.senla.bialevich.model.Service;
import ru.senla.bialevich.enums.ServicesSection;
import ru.senla.bialevich.enums.SortType;

import java.util.List;

public interface ServiceService {

    void addService(Service service);

    void addServiceToGuest(Guest guest, Service service);

    void removeServiceOfGuest(Guest guest, Service service);

    Service getService(int id);

    List<Service> getServices(Guest guest, SortType type);

    void update(Service service);

    void delete(Service service);

    List<Service> getAll(SortType type);

    List<Double> getPricesBySection(ServicesSection section);
}
