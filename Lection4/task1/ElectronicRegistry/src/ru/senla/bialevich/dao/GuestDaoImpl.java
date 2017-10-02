package ru.senla.bialevich.dao;

import ru.senla.bialevich.api.dao.GuestDao;
import ru.senla.bialevich.entity.Guest;

import java.util.List;

public class GuestDaoImpl extends AbstractDaoImpl<Guest> implements GuestDao {

    public GuestDaoImpl() {
        super(Guest.class);
    }

    @Override
    List<Guest> getTargetList() {
        return dataBase.getGuestList();
    }
}
