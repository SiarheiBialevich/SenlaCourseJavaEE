package ru.senla.bialevich.controller;

import ru.senla.bialevich.api.UsedServiceMenuController;
import ru.senla.bialevich.api.controller.ControllerHotel;
import ru.senla.bialevich.entity.UsedService;

import java.util.List;

public class UsedServiceMenuControllerImpl implements UsedServiceMenuController {
    private ControllerHotel hotel = new ControllerHotelImpl();

    @Override
    public void addUsedService(UsedService service) {
        hotel.addUsedService(service);
    }

    @Override
    public List<UsedService> sortUsedServicesByPrice() {
        return hotel.sortUsedServicesByPrice();
    }

    @Override
    public List<UsedService> getListUsedServices() {
        return hotel.getListUsedServices();
    }
}
