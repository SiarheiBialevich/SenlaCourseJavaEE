package ru.senla.bialevich.menuAction.guestAction;

import org.apache.log4j.Logger;
import ru.senla.bialevich.api.IAction;
import ru.senla.bialevich.menuAction.AbstractAction;
import ru.senla.bialevich.util.InputReader;

import java.util.Scanner;

public class AddRoomToGuest extends AbstractAction implements IAction {
    private static final Logger log = Logger.getLogger(AddRoomToGuest.class);

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        try {
            Integer idGuest = InputReader.getInputInt(scanner, "Enter ID the guest.");
            Integer idRoom = InputReader.getInputInt(scanner, "Enter ID the room.");
            hotel.setRoomToGuest(hotel.getGuestById(idGuest), hotel.getRoomById(idRoom));
        } catch (Exception e) {
            log.error("Failed to add room to guest", e);
        }
    }
}
