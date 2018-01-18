package ru.senla.bialevich.util.converter.api;

import ru.senla.bialevich.model.Guest;
import ru.senla.bialevich.model.Registration;
import ru.senla.bialevich.model.Room;
import ru.senla.bialevich.model.Service;

public interface IConverter {
    String convertGuestToString(Guest guest);

    String convertRoomToString(Room room);

    String convertServiceToString(Service service);

    String convertOrderToString(Registration registration);

    Guest convertStringToGuest(String string);

    Room convertStringToRoom(String string);

    Service convertStringToService(String string);

    Registration convertStringToRegistration(String string);
}
