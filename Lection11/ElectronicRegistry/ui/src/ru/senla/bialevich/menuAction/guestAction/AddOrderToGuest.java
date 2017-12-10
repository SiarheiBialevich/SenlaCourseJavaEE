package ru.senla.bialevich.menuAction.guestAction;

import org.apache.log4j.Logger;
import ru.senla.bialevich.entity.Guest;
import ru.senla.bialevich.entity.Registration;
import ru.senla.bialevich.menuAction.AbstractAction;
import ru.senla.bialevich.request.src.ru.senla.bialevich.DataPackage;
import ru.senla.bialevich.request.src.ru.senla.bialevich.IRequestHandler;
import ru.senla.bialevich.ui.IAction;
import ru.senla.bialevich.util.InputReader;
import ru.senla.bialevich.util.Printer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddOrderToGuest extends AbstractAction implements IAction {
    private static final Logger log = Logger.getLogger(AddOrderToGuest.class);
    private Printer printer = new Printer();

    @Override
    public void execute(IRequestHandler requestHandler) {
        Scanner scanner = new Scanner(System.in);
        Integer idGuest = InputReader.getInputInt(scanner, "Enter ID the guest.");
        Integer idOrder = InputReader.getInputInt(scanner, "Enter ID the order.");

        try {
            DataPackage dataPackage = new DataPackage("getGuest", idGuest);
            Guest guest = (Guest) requestHandler.sendRequest(dataPackage);

            dataPackage = new DataPackage("getOrder", idOrder);
            Registration registration = (Registration) requestHandler.sendRequest(dataPackage);

            if (guest == null || registration == null) {
                printer.print("Guest or registration not found");
            } else {
                List<Object> params = new ArrayList<>();
                params.add(guest);
                params.add(registration);

                dataPackage = new DataPackage("addOrderToGuest", params);
                requestHandler.sendRequest(dataPackage);
                printer.print("Registration settled.");
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }
}
