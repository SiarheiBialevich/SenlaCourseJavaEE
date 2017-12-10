package ru.senla.bialevich.menuAction.orderAction;

import org.apache.log4j.Logger;
import ru.senla.bialevich.DataPackage;
import ru.senla.bialevich.IRequestHandler;
import ru.senla.bialevich.ui.IAction;

import ru.senla.bialevich.entity.Order;
import ru.senla.bialevich.util.InputReader;
import ru.senla.bialevich.util.Printer;

import java.util.Date;
import java.util.Scanner;

public class AddOrder implements IAction {
    private static final Logger log = Logger.getLogger(AddOrder.class);

    @Override
    public void execute(IRequestHandler requestHandler) {
        Scanner scanner = new Scanner(System.in);

        Printer printer = new Printer();

        try {
            Integer orderNumber = InputReader.getInputInt(scanner, "Enter the number of the order.");
            Date dateOfArrival = InputReader.getInputDate(scanner, "Enter the date of arrival (format dd/MM/yyyy).");
            Date dateOfDeparture = InputReader.getInputDate(scanner, "Enter the date of departure (format dd/MM/yyyy).");

            Order order = new Order(orderNumber, dateOfArrival, dateOfDeparture);

            DataPackage dataPackage = new DataPackage("addOrder", order);
            requestHandler.sendRequest(dataPackage);

            printer.print("Order created.");
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}
