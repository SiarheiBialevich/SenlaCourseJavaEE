package ru.senla.bialevich.api.service;

import ru.senla.bialevich.entity.Guest;

import java.util.List;

public interface GuestService {

    void add(Guest guest);

    void getAll();

    void getTotalNumberOfGuests();

    void sortedGuestsBySurname();

    void sortedGuestsByDateOfDeparture();

    void getServiceByGuest(Guest guest);

    List<Guest> getListGuests();
}
