package ru.senla.bialevich.menuAction.orderAction;

import org.apache.log4j.Logger;
import ru.senla.bialevich.api.IAction;

import ru.senla.bialevich.controller.ControllerHotelImpl;
import ru.senla.bialevich.entity.Order;
import ru.senla.bialevich.util.InputReader;

import java.util.Date;
import java.util.Scanner;

public class AddOrder implements IAction {
    private static final Logger log = Logger.getLogger(AddOrder.class);

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        try {
            Integer orderNumber = InputReader.getInputInt(scanner, "Enter the number of the order.");
            Date dateOfArrival = InputReader.getInputDate(scanner, "Enter the date of arrival (format dd/MM/yyyy).");
            Date dateOfDeparture = InputReader.getInputDate(scanner, "Enter the date of departure (format dd/MM/yyyy).");

            ControllerHotelImpl.getInstance().addOrder(new Order(orderNumber, dateOfArrival, dateOfDeparture));
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}
