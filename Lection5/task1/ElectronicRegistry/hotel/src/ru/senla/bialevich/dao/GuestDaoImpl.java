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

    public Guest getGuestById(Integer id) {
        Guest guest = null;
        for (int i = 0; i < getTargetList().size(); i++) {
            if (getTargetList().get(i).getId().equals(id)) {
                guest = getTargetList().get(i);
            }
        }

        return guest;
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
}
