package ru.senla.bialevich.dao;

import ru.senla.bialevich.api.dao.GuestDao;
import ru.senla.bialevich.entity.Guest;
import ru.senla.bialevich.entity.Order;
import ru.senla.bialevich.entity.Room;

import java.util.List;

public class GuestDaoImpl extends AbstractDaoImpl<Guest> implements GuestDao {

    public GuestDaoImpl() {
        super(Guest.class);
    }

    public GuestDaoImpl(List<Guest> guests) {
        super(Guest.class);
    }

    public Guest getGuestById(Integer id) {
        Guest guest = null;
        for (int i = 0; i < getTargetList().size(); i++) {
            if (getTargetList().get(i).getId().equals(id)) {
                guest = getTargetList().get(i);
            }
        }

        return guest;
    }

    @Override
    public Integer getGuestIndexById(Integer id) {
        for (int i = 0; i < getTargetList().size(); i++) {
            if (getTargetList().get(i).getId() == id) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public void update(Guest guest) {
        getTargetList().set(getGuestIndexById(guest.getId()), guest);
    }

    public void setRoomToGuest(Guest guest, Room room) {
        guest.setRoom(room);
    }

    @Override
    public void setOrderToGuest(Guest guest, Order order) {
        guest.setOrder(order);
    }

    @Override
    List<Guest> getTargetList() {
        return dataBase.getGuestList();
    }

    @Override
    public void setGuestList(List<Guest> guests) {
        dataBase.setGuestList(guests);
    }
}
