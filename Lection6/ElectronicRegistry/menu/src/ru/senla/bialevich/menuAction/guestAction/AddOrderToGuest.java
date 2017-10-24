package ru.senla.bialevich.menuAction.guestAction;

import org.apache.log4j.Logger;
import ru.senla.bialevich.api.IAction;
import ru.senla.bialevich.menuAction.AbstractAction;
import ru.senla.bialevich.util.InputReader;

import java.util.Scanner;

public class AddOrderToGuest extends AbstractAction implements IAction {
    private static final Logger log = Logger.getLogger(AddOrderToGuest.class);

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        try {
            Integer idGuest = InputReader.getInputInt(scanner, "Enter ID the guest.");
            Integer idOrder = InputReader.getInputInt(scanner, "Enter ID the order.");

            hotel.setOrderToGuest(hotel.getGuestById(idGuest), hotel.getOrderById(idOrder));
        } catch (Exception e) {
            log.error("Failed to add order to guest", e);
        }
    }
}
