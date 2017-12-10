package ru.senla.bialevich.menuAction.orderAction;

import org.apache.log4j.Logger;
import ru.senla.bialevich.entity.Registration;
import ru.senla.bialevich.request.src.ru.senla.bialevich.DataPackage;
import ru.senla.bialevich.request.src.ru.senla.bialevich.IRequestHandler;
import ru.senla.bialevich.ui.IAction;
import ru.senla.bialevich.util.Printer;

import java.util.List;

public class GetRegistrationList implements IAction {
    private static final Logger log = Logger.getLogger(GetRegistrationList.class);

    @Override
    public void execute(IRequestHandler requestHandler) {
        Printer printer = new Printer();

        try {
            DataPackage dataPackage = new DataPackage("getAllOrders", null);
            List<Registration> registrations = (List<Registration>) requestHandler.sendRequest(dataPackage);
            if (registrations == null) {
                printer.print("Registration nit found.");
            } else {
                printer.print(registrations);
            }

        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}
