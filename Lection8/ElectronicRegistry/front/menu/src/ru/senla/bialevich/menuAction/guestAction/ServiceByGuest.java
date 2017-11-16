package ru.senla.bialevich.menuAction.guestAction;

import org.apache.log4j.Logger;
import ru.senla.bialevich.IRequestHandler;
import ru.senla.bialevich.api.IAction;
import ru.senla.bialevich.menuAction.AbstractAction;
import ru.senla.bialevich.util.InputReader;
import ru.senla.bialevich.util.Printer;

import java.util.Scanner;

public class ServiceByGuest extends AbstractAction implements IAction {
    private static final Logger log = Logger.getLogger(ServiceByGuest.class);

    @Override
    public void execute(IRequestHandler requestHandler) {
        Scanner scanner = new Scanner(System.in);
        Printer printer = new Printer();

        try {
            Integer id = InputReader.getInputInt(scanner, "Enter ID the guest.");
            printer.print(hotel.getServiceByGuest(hotel.getGuestById(id)));
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}
