package ru.senla.bialevich.menuAction.guestAction;

import org.apache.log4j.Logger;
import ru.senla.bialevich.DataPackage;
import ru.senla.bialevich.IRequestHandler;
import ru.senla.bialevich.api.IAction;
import ru.senla.bialevich.entity.Guest;
import ru.senla.bialevich.entity.Order;
import ru.senla.bialevich.entity.Room;
import ru.senla.bialevich.menuAction.AbstractAction;
import ru.senla.bialevich.util.InputReader;
import ru.senla.bialevich.util.Printer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddRoomToGuest extends AbstractAction implements IAction {
    private static final Logger log = Logger.getLogger(AddRoomToGuest.class);
    private Printer printer = new Printer();

    @Override
    public void execute(IRequestHandler requestHandler) {
        Scanner scanner = new Scanner(System.in);
        Integer idGuest = InputReader.getInputInt(scanner, "Enter ID the guest.");
        Integer idRoom = InputReader.getInputInt(scanner, "Enter ID the room.");

        try {
            DataPackage dataPackage = new DataPackage("getGuest", idGuest);
            Guest guest = (Guest) requestHandler.sendRequest(dataPackage);

            dataPackage = new DataPackage("getOrder", idRoom);
            Room room = (Room) requestHandler.sendRequest(dataPackage);

            if (guest == null || room == null) {
                printer.print("Guest or room not found");
            } else {
                List<Object> params = new ArrayList<>();
                params.add(guest);
                params.add(room);

                dataPackage = new DataPackage("addOrderToGuest", params);
                requestHandler.sendRequest(dataPackage);
                printer.print("Room settled.");
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }
}
