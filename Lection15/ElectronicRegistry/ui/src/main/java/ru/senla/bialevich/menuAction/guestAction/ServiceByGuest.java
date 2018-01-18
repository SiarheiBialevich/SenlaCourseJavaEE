package ru.senla.bialevich.menuAction.guestAction;

import org.apache.log4j.Logger;
import ru.senla.bialevich.model.Guest;
import ru.senla.bialevich.model.Service;
import ru.senla.bialevich.menuAction.AbstractAction;
import ru.senla.bialevich.request.src.ru.senla.bialevich.DataPackage;
import ru.senla.bialevich.request.src.ru.senla.bialevich.IRequestHandler;
import ru.senla.bialevich.ui.IAction;
import ru.senla.bialevich.util.InputReader;

import java.util.List;
import java.util.Scanner;

public class ServiceByGuest extends AbstractAction implements IAction {
    private static final Logger log = Logger.getLogger(ServiceByGuest.class);

    @Override
    public void execute(IRequestHandler requestHandler) {
        Scanner scanner = new Scanner(System.in);
        Integer id = InputReader.getInputInt(scanner, "Enter ID the guest.");

        try {
            DataPackage dataPackage = new DataPackage("getGuest", id);
            Guest guest = (Guest) requestHandler.sendRequest(dataPackage);

            dataPackage = new DataPackage("getAllServices", null);
            List<Service> services = (List<Service>) requestHandler.sendRequest(dataPackage);
            if (guest == null || services == null) {
                System.out.println("Guest or services not found");
            } else {
                System.out.println(services);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}
