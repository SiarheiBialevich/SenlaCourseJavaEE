package ru.senla.bialevich.menuAction.guestAction;

import org.apache.log4j.Logger;
import ru.senla.bialevich.DataPackage;
import ru.senla.bialevich.IRequestHandler;
import ru.senla.bialevich.api.IAction;
import ru.senla.bialevich.entity.Guest;
import ru.senla.bialevich.entity.UsedService;
import ru.senla.bialevich.menuAction.AbstractAction;
import ru.senla.bialevich.util.InputReader;
import ru.senla.bialevich.util.Printer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ServiceByGuest extends AbstractAction implements IAction {
    private static final Logger log = Logger.getLogger(ServiceByGuest.class);
    private Printer printer = new Printer();

    @Override
    public void execute(IRequestHandler requestHandler) {
        Scanner scanner = new Scanner(System.in);
        Integer id = InputReader.getInputInt(scanner, "Enter ID the guest.");

        try {
            DataPackage dataPackage = new DataPackage("getGuest", id);
            Guest guest = (Guest) requestHandler.sendRequest(dataPackage);

            dataPackage = new DataPackage("getAllServices", null);
            List<UsedService> services = (List<UsedService>) requestHandler.sendRequest(dataPackage);
            if (guest == null || services == null) {
                printer.print("Guest or services not found");
            } else {
                printer.print(services);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}
