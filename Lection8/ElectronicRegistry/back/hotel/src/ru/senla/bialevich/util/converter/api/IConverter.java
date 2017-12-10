package ru.senla.bialevich.util.converter.api;

import ru.senla.bialevich.entity.Guest;
import ru.senla.bialevich.entity.Order;
import ru.senla.bialevich.entity.Room;
import ru.senla.bialevich.entity.UsedService;

public interface IConverter {
    String convertGuestToString(Guest guest);

    String convertRoomToString(Room room);

    String convertServiceToString(UsedService service);

    String convertOrderToString(Order order);

    Guest convertStringToGuest(String string);

    Room convertStringToRoom(String string);

    UsedService convertStringToService(String string);

    Order convertStringToOrder(String string);
}
