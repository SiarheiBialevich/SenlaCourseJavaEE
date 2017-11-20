package ru.senla.bialevich.dao;

import ru.senla.bialevich.entity.Guest;
import ru.senla.bialevich.entity.Order;
import ru.senla.bialevich.entity.Room;

import java.util.List;

public interface GuestDao extends AbstractDao<Guest> {

    Guest getGuestById(Integer id);

    Integer getGuestIndexById(Integer id);

    void setRoomToGuest(Guest guest, Room room);

    void setOrderToGuest(Guest guest, Order order);

    void setGuestList(List<Guest> guests);

    void update(Guest guest);

}
