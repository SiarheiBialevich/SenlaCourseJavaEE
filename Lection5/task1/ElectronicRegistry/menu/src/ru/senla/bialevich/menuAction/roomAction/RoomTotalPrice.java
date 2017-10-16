package ru.senla.bialevich.menuAction.roomAction;

import ru.senla.bialevich.api.IAction;
import ru.senla.bialevich.api.controller.ControllerHotel;
import ru.senla.bialevich.controller.ControllerHotelImpl;
import ru.senla.bialevich.util.InputReader;
import ru.senla.bialevich.util.Printer;

import java.util.Scanner;

public class RoomTotalPrice implements IAction {

    @Override
    public void execute() {
        ControllerHotel hotel = new ControllerHotelImpl();
        Printer printer = new Printer();
        InputReader reader = new InputReader();
        Scanner scanner = new Scanner(System.in);

        Integer idRoom = reader.getInputInt(scanner, "Enter ID the room.");
        printer.print(hotel.getRoomTotalPrice(hotel.getRoomById(idRoom)));
    }
}
