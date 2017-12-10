package ru.senla.bialevich.api.dao;

import ru.senla.bialevich.entity.Guest;
import ru.senla.bialevich.entity.Order;
import ru.senla.bialevich.entity.Room;

public interface GuestDao extends AbstractDao<Guest> {

    Guest getGuestById(Integer id);

    void setRoomToGuest(Guest guest, Room room);

    void setOrderToGuest(Guest guest, Order order);

}
