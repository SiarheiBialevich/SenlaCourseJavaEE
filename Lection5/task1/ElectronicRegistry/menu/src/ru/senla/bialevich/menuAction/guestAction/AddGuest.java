package ru.senla.bialevich.menuAction.guestAction;

import org.apache.log4j.Logger;
import ru.senla.bialevich.api.IAction;
import ru.senla.bialevich.controller.ControllerHotelImpl;
import ru.senla.bialevich.entity.Guest;
import ru.senla.bialevich.util.InputReader;

import java.util.Scanner;

public class AddGuest implements IAction {
    private static final Logger log = Logger.getLogger(AddGuest.class);

    @Override
    public void execute() {

        Scanner scanner = new Scanner(System.in);

        try {
            String name = InputReader.getInputString(scanner, "Enter the name of the guest.");
            String surname = InputReader.getInputString(scanner, "Enter the surname of the guest.");

            ControllerHotelImpl.getInstance().addGuest(new Guest(name, surname));
        } catch (Exception e) {
            log.error("Failed to add guest", e);
        }

    }
}
