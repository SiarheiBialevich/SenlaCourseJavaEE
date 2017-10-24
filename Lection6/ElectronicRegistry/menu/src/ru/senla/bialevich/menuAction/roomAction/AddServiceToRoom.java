package ru.senla.bialevich.menuAction.roomAction;

import org.apache.log4j.Logger;
import ru.senla.bialevich.api.IAction;
import ru.senla.bialevich.menuAction.AbstractAction;
import ru.senla.bialevich.util.InputReader;

import java.util.Scanner;

public class AddServiceToRoom extends AbstractAction implements IAction {
    private static final Logger log = Logger.getLogger(AddServiceToRoom.class);

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        try {
            Integer idRoom = InputReader.getInputInt(scanner, "Enter ID the room.");
            Integer idService = InputReader.getInputInt(scanner, "Enter ID the used service.");
            hotel.setServiceToRoom(hotel.getRoomById(idRoom), hotel.getServiceById(idService));
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}
