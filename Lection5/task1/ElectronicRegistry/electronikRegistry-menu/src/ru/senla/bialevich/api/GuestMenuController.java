package ru.senla.bialevich.api;

import ru.senla.bialevich.entity.Guest;
import ru.senla.bialevich.entity.Order;
import ru.senla.bialevich.entity.Room;
import ru.senla.bialevich.entity.UsedService;

import java.util.List;

public interface GuestMenuController {

    void addGuest(Guest guest);

    List<Guest> getAllGuest();

    Integer getTotalNumberOfGuests();

    List<UsedService> getServiceByGuest(Guest guest);

    List<Guest> sortedGuestsBySurname();

    List<Guest> sortedGuestsByDateOfDeparture();

    void addRoomToTheGuest(Guest guest, Room room);

    void addOrderToTheGuest(Guest guest, Order order);

}
