package ru.senla.bialevich.controller;

import ru.senla.bialevich.api.UsedServiceMenuController;
import ru.senla.bialevich.api.controller.ControllerHotel;
import ru.senla.bialevich.entity.UsedService;
import ru.senla.bialevich.util.ReadServiceFromFile;
import ru.senla.bialevich.util.WriteToFile;

import java.util.List;

public class UsedServiceMenuControllerImpl implements UsedServiceMenuController {
    private ControllerHotel hotel = new ControllerHotelImpl();
    private WriteToFile writeToFile = new WriteToFile();
    private ReadServiceFromFile readServiceFromFile = new ReadServiceFromFile();

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

    @Override
    public UsedService getServiceById(Integer id) {
        return hotel.getServiceById(id);
    }

    @Override
    public void writeToFile(String filePath, List<UsedService> services) {
        writeToFile.write(filePath, services);
    }

    @Override
    public List<UsedService> readFromFile(String filePath) {
        return readServiceFromFile.read(filePath);
    }
}
