package ru.senla.bialevich.menuAction.roomAction;

import org.apache.log4j.Logger;
import ru.senla.bialevich.api.IAction;
import ru.senla.bialevich.entity.Room;
import ru.senla.bialevich.menuAction.AbstractAction;
import ru.senla.bialevich.util.InputReader;
import ru.senla.bialevich.util.Printer;

import java.util.Scanner;

public class ChangeRoomPrice extends AbstractAction implements IAction {
    private static final Logger LOG = Logger.getLogger(ChangeRoomStatus.class);
    private Printer printer = new Printer();

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        Integer roomId = InputReader.getInputInt(scanner, "Input room ID: ");

        try {
            Room room = hotel.getRoomById(roomId);

            if (room == null) {
                printer.print("Room not found.");
            } else {
                Float value = InputReader.getInputFloat(scanner, "Input new price for room:");
                hotel.changeRoomPrice(room, value);
            }
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
    }
}
