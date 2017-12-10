package ru.senla.bialevich.menuAction.roomAction;

import org.apache.log4j.Logger;
import ru.senla.bialevich.DataPackage;
import ru.senla.bialevich.IRequestHandler;
import ru.senla.bialevich.ui.IAction;
import ru.senla.bialevich.entity.Room;
import ru.senla.bialevich.menuAction.AbstractAction;
import ru.senla.bialevich.util.InputReader;
import ru.senla.bialevich.util.Printer;

import java.util.Scanner;

public class RoomTotalPrice extends AbstractAction implements IAction {
    private static final Logger log = Logger.getLogger(RoomTotalPrice.class);

    @Override
    public void execute(IRequestHandler requestHandler) {
        Printer printer = new Printer();
        Scanner scanner = new Scanner(System.in);
        Integer idRoom = InputReader.getInputInt(scanner, "Enter ID the room.");

        try {
            DataPackage dataPackage = new DataPackage("getRoom", idRoom);
            Room room = (Room) requestHandler.sendRequest(dataPackage);

            if (room == null) {
                printer.print("Room not found.");
            } else {
                printer.print(room);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}
