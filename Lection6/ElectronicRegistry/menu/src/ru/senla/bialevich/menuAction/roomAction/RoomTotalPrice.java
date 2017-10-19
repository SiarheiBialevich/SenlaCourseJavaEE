package ru.senla.bialevich.menuAction.roomAction;

import org.apache.log4j.Logger;
import ru.senla.bialevich.api.IAction;
import ru.senla.bialevich.controller.ControllerHotelImpl;
import ru.senla.bialevich.util.InputReader;
import ru.senla.bialevich.util.Printer;

import java.util.Scanner;

public class RoomTotalPrice implements IAction {
    private static final Logger log = Logger.getLogger(RoomTotalPrice.class);

    @Override
    public void execute() {
        Printer printer = new Printer();
        Scanner scanner = new Scanner(System.in);

        try {
            Integer idRoom = InputReader.getInputInt(scanner, "Enter ID the room.");

            if (ControllerHotelImpl.getInstance().getRoomById(idRoom) == null) {
                printer.print("Room not found.");
            } else {
                printer.print(ControllerHotelImpl.getInstance().getRoomTotalPrice(ControllerHotelImpl.getInstance().getRoomById(idRoom)));
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}
