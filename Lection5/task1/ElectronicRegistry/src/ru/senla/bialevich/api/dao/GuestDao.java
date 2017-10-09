package ru.senla.bialevich.api.dao;

import ru.senla.bialevich.entity.Guest;

public interface GuestDao extends AbstractDao<Guest> {

    Guest getGuestById(Integer id);
}
