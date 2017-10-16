package ru.senla.bialevich.menuAction.guestAction;

import ru.senla.bialevich.api.IAction;
import ru.senla.bialevich.api.controller.ControllerHotel;
import ru.senla.bialevich.controller.ControllerHotelImpl;
import ru.senla.bialevich.util.InputReader;
import ru.senla.bialevich.util.Printer;

import java.util.Scanner;

public class ServiceByGuest implements IAction {

    @Override
    public void execute() {
        ControllerHotel hotel = new ControllerHotelImpl();
        InputReader reader = new InputReader();
        Scanner scanner = new Scanner(System.in);
        Printer printer = new Printer();

        Integer id = reader.getInputInt(scanner, "Enter ID the guest.");
        printer.print(hotel.getServiceByGuest(hotel.getGuestById(id)));
    }
}
