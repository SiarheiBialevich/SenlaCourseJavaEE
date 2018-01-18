package ru.senla.bialevich.menuAction.serviceAction;

import org.apache.log4j.Logger;
import ru.senla.bialevich.model.Service;
import ru.senla.bialevich.enums.ServicesSection;
import ru.senla.bialevich.menuAction.AbstractAction;
import ru.senla.bialevich.request.src.ru.senla.bialevich.DataPackage;
import ru.senla.bialevich.request.src.ru.senla.bialevich.IRequestHandler;
import ru.senla.bialevich.ui.IAction;
import ru.senla.bialevich.util.InputReader;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class AddService extends AbstractAction implements IAction {
    private static final Logger log = Logger.getLogger(AddService.class);

    @Override
    public void execute(IRequestHandler requestHandler) {
        Scanner scanner = new Scanner(System.in);

        try {
            List<Object> objects = new ArrayList<>();
            String name = InputReader.getInputString(scanner, "Enter the name of the services.");
            Double price = InputReader.getInputDouble(scanner, "Enter the price of the services.");
            String strSection = InputReader.getInputString(scanner, "Input room section: ");
//            ServicesSection section = ServicesSection.isExist(strSection.toUpperCase());
            Date startDate = InputReader.getInputDate(scanner, "Input start date - (dd-mm-yyyy): ");
            Date finalDate = InputReader.getInputDate(scanner, "Input final date - (dd-mm-yyyy): ");
//            Service service = new Service(name, price, section, startDate, finalDate);
//            objects.add(service);
//            DataPackage dataPackage = new DataPackage("addService", service);
//            requestHandler.sendRequest(dataPackage);

            System.out.println("Service created.");
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }
}
