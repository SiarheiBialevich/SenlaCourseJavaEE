package ru.senla.bialevich.menuAction.serviceAction;

import org.apache.log4j.Logger;
import ru.senla.bialevich.DataPackage;
import ru.senla.bialevich.IRequestHandler;
import ru.senla.bialevich.ui.IAction;
import ru.senla.bialevich.entity.UsedService;
import ru.senla.bialevich.menuAction.AbstractAction;
import ru.senla.bialevich.util.InputReader;
import ru.senla.bialevich.util.Printer;

import java.util.Scanner;

public class AddService extends AbstractAction implements IAction {
    private static final Logger log = Logger.getLogger(AddService.class);

    @Override
    public void execute(IRequestHandler requestHandler) {
        Scanner scanner = new Scanner(System.in);

        Printer printer = new Printer();

        try {
            String nameService = InputReader.getInputString(scanner, "Enter the name of the services.");
            Float price = InputReader.getInputFloat(scanner, "Enter the price of the services.");
            UsedService service = new UsedService(nameService, price);
            DataPackage dataPackage = new DataPackage("addService", service);
            requestHandler.sendRequest(dataPackage);

            printer.print("Service created.");
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }
}
