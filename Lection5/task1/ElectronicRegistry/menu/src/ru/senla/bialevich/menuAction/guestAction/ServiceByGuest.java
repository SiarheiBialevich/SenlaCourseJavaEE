package ru.senla.bialevich.menuAction.guestAction;

import org.apache.log4j.Logger;
import ru.senla.bialevich.api.IAction;
import ru.senla.bialevich.controller.ControllerHotelImpl;
import ru.senla.bialevich.util.InputReader;
import ru.senla.bialevich.util.Printer;

import java.util.Scanner;

public class ServiceByGuest implements IAction {
    private static final Logger log = Logger.getLogger(ServiceByGuest.class);

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        Printer printer = new Printer();

        try {
            Integer id = InputReader.getInputInt(scanner, "Enter ID the guest.");
            printer.print(ControllerHotelImpl.getInstance().getServiceByGuest(ControllerHotelImpl.getInstance().getGuestById(id)));
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}
