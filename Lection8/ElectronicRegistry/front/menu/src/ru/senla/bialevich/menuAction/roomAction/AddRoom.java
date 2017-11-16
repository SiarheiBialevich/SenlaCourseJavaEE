package ru.senla.bialevich.menuAction.roomAction;

import org.apache.log4j.Logger;
import ru.senla.bialevich.DataPackage;
import ru.senla.bialevich.IRequestHandler;
import ru.senla.bialevich.api.IAction;
import ru.senla.bialevich.entity.Room;
import ru.senla.bialevich.menuAction.AbstractAction;
import ru.senla.bialevich.util.InputReader;
import ru.senla.bialevich.util.Printer;

import java.util.Scanner;

public class AddRoom extends AbstractAction implements IAction {
    private static final Logger log = Logger.getLogger(AddRoom.class);

    @Override
    public void execute(IRequestHandler requestHandler) {
        Scanner scanner = new Scanner(System.in);
        Printer printer = new Printer();

        try {
            Integer roomNumber = InputReader.getInputInt(scanner, "Enter the number of the room.");
            Integer countStars = InputReader.getInputInt(scanner, "Enter the count stars of the room.");
            Integer capacity = InputReader.getInputInt(scanner, "Enter the count of beds of the room.");
            Float price = InputReader.getInputFloat(scanner, "Enter the price of the room.");

            Room room = new Room(roomNumber, countStars, capacity, price);
            DataPackage dataPackage = new DataPackage("addRoom", room);
            requestHandler.sendRequest(dataPackage);

            printer.print("Room created.");
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}
