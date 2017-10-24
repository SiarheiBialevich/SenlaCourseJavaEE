package ru.senla.bialevich.menuAction.roomAction;


import org.apache.log4j.Logger;
import ru.senla.bialevich.api.IAction;
import ru.senla.bialevich.entity.Room;
import ru.senla.bialevich.menuAction.AbstractAction;
import ru.senla.bialevich.util.InputReader;
import ru.senla.bialevich.util.Printer;

import java.util.Scanner;

public class ChangeRoomStatus extends AbstractAction implements IAction {
    private static final Logger LOG = Logger.getLogger(ChangeRoomStatus.class);
    private Printer printer = new Printer();

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        Integer roomId = InputReader.getInputInt(scanner, "Input room ID: ");
        Room room = hotel.getRoomById(roomId);

        if(!hotel.changeRoomStatus(room)) {
            printer.print("Can't change the status of the rooms!");
        }else {
            try {
                if (room == null) {
                    printer.print("Room not found.");
                } else {
                    hotel.changeRoomStatus(room);
                    printer.print("Room status is changed.");
                }
            } catch (Exception e) {
                LOG.error(e.getMessage(), e);
            }
        }
    }
}
