package ru.senla.bialevich.menuAction.orderAction;

import ru.senla.bialevich.api.IAction;
import ru.senla.bialevich.api.controller.ControllerHotel;
import ru.senla.bialevich.controller.ControllerHotelImpl;
import ru.senla.bialevich.entity.Order;
import ru.senla.bialevich.util.InputReader;

import java.util.Date;
import java.util.Scanner;

public class AddOrder implements IAction {

    @Override
    public void execute() {
        ControllerHotel hotel = new ControllerHotelImpl();
        InputReader reader = new InputReader();
        Scanner scanner = new Scanner(System.in);

        Integer id = reader.getInputInt(scanner, "Enter ID of the order");
        Integer orderNumber = reader.getInputInt(scanner, "Enter the number of the order.");
        Date dateOfArrival = reader.getInputDate(scanner, "Enter the date of arrival (format dd/MM/yyyy).");
        Date dateOfDeparture = reader.getInputDate(scanner, "Enter the date of departure (format dd/MM/yyyy).");

        hotel.addOrder(new Order(id, orderNumber, dateOfArrival, dateOfDeparture));
    }
}
