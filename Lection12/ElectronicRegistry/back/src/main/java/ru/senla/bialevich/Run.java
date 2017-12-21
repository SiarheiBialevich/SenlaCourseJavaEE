package ru.senla.bialevich;

import ru.senla.bialevich.connectordb.HibernateUtil;
import ru.senla.bialevich.controller.ControllerHotel;
import ru.senla.bialevich.dependency.DependencyInjection;
import ru.senla.bialevich.model.Guest;

import java.util.List;

public class Run {
    public static void main(String[] args) {

        ControllerHotel hotel = (ControllerHotel) DependencyInjection.getInjection().getInstance(ControllerHotel.class);

        List<Guest> guests= hotel.getAllGuests();

        for (Guest guest : guests) {
            System.out.println(guest.getName() + ", " + guest.getSurname());
        }


        HibernateUtil.shutdown();
    }
}
