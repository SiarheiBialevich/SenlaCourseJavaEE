package ru.senla.bialevich.menuAction.guestAction;

import org.apache.log4j.Logger;
import ru.senla.bialevich.DataPackage;
import ru.senla.bialevich.IRequestHandler;
import ru.senla.bialevich.ui.IAction;
import ru.senla.bialevich.entity.Guest;
import ru.senla.bialevich.menuAction.AbstractAction;
import ru.senla.bialevich.util.InputReader;
import ru.senla.bialevich.util.Printer;

import java.util.Scanner;

public class AddGuest extends AbstractAction implements IAction {
    private static final Logger log = Logger.getLogger(AddGuest.class);

    @Override
    public void execute(IRequestHandler requestHandler) {

        Scanner scanner = new Scanner(System.in);

        Printer printer = new Printer();

        try {
            String name = InputReader.getInputString(scanner, "Enter the name of the guest.");
            String surname = InputReader.getInputString(scanner, "Enter the surname of the guest.");

            Guest guest = new Guest(name, surname);
            DataPackage dataPackage = new DataPackage("addGuest", guest);
            requestHandler.sendRequest(dataPackage);

            printer.print("Guest created.");
        } catch (Exception e) {
            log.error("Failed to add guest", e);
        }

    }
}
