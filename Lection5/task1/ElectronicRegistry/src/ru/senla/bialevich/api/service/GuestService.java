package ru.senla.bialevich.api.service;

import ru.senla.bialevich.entity.Guest;
import ru.senla.bialevich.entity.UsedService;

import java.util.List;

public interface GuestService {

    void add(Guest guest);

    Guest getGuestById(Integer id);

    List<Guest> getAll();

    Integer getTotalNumberOfGuests();

    List<Guest> sortedGuestsBySurname();

    List<Guest> sortedGuestsByDateOfDeparture();

    List<UsedService> getServiceByGuest(Guest guest);

    List<Guest> getListGuests();
}
