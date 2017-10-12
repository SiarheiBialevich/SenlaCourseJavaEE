package ru.senla.bialevich.controller;

import ru.senla.bialevich.api.GuestMenuController;
import ru.senla.bialevich.api.controller.ControllerHotel;
import ru.senla.bialevich.entity.Guest;
import ru.senla.bialevich.entity.Order;
import ru.senla.bialevich.entity.Room;
import ru.senla.bialevich.entity.UsedService;
import ru.senla.bialevich.util.ReadGuestFromFile;
import ru.senla.bialevich.util.WriteToFile;

import java.util.List;

public class GuestMenuControllerImpl implements GuestMenuController {
    private ControllerHotel hotel = new ControllerHotelImpl();
    private WriteToFile writeToFile = new WriteToFile();
    ReadGuestFromFile readFromFile = new ReadGuestFromFile();

    @Override
    public void addGuest(Guest guest) {
        hotel.addGuest(guest);
    }

    @Override
    public List<Guest> getAllGuest() {
        return hotel.getAllGuest();
    }

    @Override
    public Integer getTotalNumberOfGuests() {
        return hotel.getTotalNumberOfGuests();
    }

    @Override
    public List<UsedService> getServiceByGuest(Guest guest) {
        return hotel.getServiceByGuest(guest);
    }

    @Override
    public List<Guest> sortedGuestsBySurname() {
        return hotel.sortedGuestsBySurname();
    }

    @Override
    public List<Guest> sortedGuestsByDateOfDeparture() {
        return hotel.sortedGuestsByDateOfDeparture();
    }

    @Override
    public void addRoomToTheGuest(Guest guest, Room room) {
        guest.setRoom(room);
    }

    @Override
    public void addOrderToTheGuest(Guest guest, Order order) {
        guest.setOrder(order);
    }

    @Override
    public Guest getGuestById(Integer id) {
        return hotel.getGuestById(id);
    }

    @Override
    public void writeToFile(String filePath, List<Guest> guests) {
        writeToFile.write(filePath, guests);
    }

    @Override
    public List<Guest> readFromFile(String filePath) {
        return readFromFile.read(filePath);
    }
}
