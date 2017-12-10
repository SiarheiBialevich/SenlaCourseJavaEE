package ru.senla.bialevich.menuAction.roomAction;

import org.apache.log4j.Logger;
import ru.senla.bialevich.api.IAction;
import ru.senla.bialevich.menuAction.AbstractAction;
import ru.senla.bialevich.util.InputReader;
import ru.senla.bialevich.util.Printer;

import java.util.Scanner;

public class RoomTotalPrice extends AbstractAction implements IAction {
    private static final Logger log = Logger.getLogger(RoomTotalPrice.class);

    @Override
    public void execute() {
        Printer printer = new Printer();
        Scanner scanner = new Scanner(System.in);

        try {
            Integer idRoom = InputReader.getInputInt(scanner, "Enter ID the room.");

            if (hotel.getRoomById(idRoom) == null) {
                printer.print("Room not found.");
            } else {
                printer.print(hotel.getRoomTotalPrice(hotel.getRoomById(idRoom)));
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}
