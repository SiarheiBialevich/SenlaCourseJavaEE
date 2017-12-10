package ru.senla.bialevich.menuAction.roomAction;

import org.apache.log4j.Logger;
import ru.senla.bialevich.DataPackage;
import ru.senla.bialevich.IRequestHandler;
import ru.senla.bialevich.ui.IAction;
import ru.senla.bialevich.entity.Guest;
import ru.senla.bialevich.entity.Room;
import ru.senla.bialevich.menuAction.AbstractAction;
import ru.senla.bialevich.util.InputReader;
import ru.senla.bialevich.util.Printer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RegisterGuestInRoom extends AbstractAction implements IAction {
    private static final Logger log = Logger.getLogger(RegisterGuestInRoom.class);
    private Printer printer = new Printer();

    @Override
    public void execute(IRequestHandler requestHandler) {
        Scanner scanner = new Scanner(System.in);
        Integer idGuest = InputReader.getInputInt(scanner, "Enter ID the guest.");
        Integer idRoom = InputReader.getInputInt(scanner, "Enter ID the room.");

        try {
            DataPackage dataPackage = new DataPackage("getRoom", idRoom);
            Room room = (Room) requestHandler.sendRequest(dataPackage);

            dataPackage = new DataPackage("getServices", idGuest);
            Guest guest = (Guest) requestHandler.sendRequest(dataPackage);

            if (room == null || guest == null) {
                printer.print("Room or guest not found");
            } else {
                List<Object> params = new ArrayList<>();
                params.add(room);
                params.add(guest);

                dataPackage = new DataPackage("addServiceToRoom", params);
                requestHandler.sendRequest(dataPackage);
                printer.print("Guest settled.");
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }
}
