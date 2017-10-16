package ru.senla.bialevich.menuAction.guestAction;

import ru.senla.bialevich.api.IAction;
import ru.senla.bialevich.api.controller.ControllerHotel;
import ru.senla.bialevich.controller.ControllerHotelImpl;
import ru.senla.bialevich.entity.Guest;
import ru.senla.bialevich.util.InputReader;

import java.util.Scanner;

public class AddGuest implements IAction {
    @Override
    public void execute() {
        ControllerHotel hotel = new ControllerHotelImpl();
        InputReader reader = new InputReader();
        Scanner scanner = new Scanner(System.in);

        Integer id = reader.getInputInt(scanner, "Enter ID the guest.");
        String name = reader.getInputString(scanner, "Enter the name of the guest.");
        String surname = reader.getInputString(scanner, "Enter the surname of the guest.");

        hotel.addGuest(new Guest(id, name, surname));
    }
}
