package ru.senla.bialevich.menu;

import ru.senla.bialevich.api.OrderMenuController;
import ru.senla.bialevich.entity.Order;
import ru.senla.bialevich.enums.OrderMenuConstEnum;
import ru.senla.bialevich.util.InputReader;
import ru.senla.bialevich.util.Printer;

import java.util.Date;
import java.util.Scanner;

public class OrderMenu {
    private Scanner scanner = new Scanner(System.in);
    private Printer printer = new Printer();
    private InputReader reader = new InputReader();
    private OrderMenuController orderMenu;

    public OrderMenu(OrderMenuController orderMenu) {
        this.orderMenu = orderMenu;
    }

    public void start() {

        printer.print("Select the required action");

        boolean exit = false;

        while (!exit) {
            Integer i = 0;
            for (OrderMenuConstEnum menu : OrderMenuConstEnum.values()) {
                printer.print((i + 1) + ". " + menu.getDescription());
                i++;
            }

            Integer choice = reader.getInputInt(scanner);
            if (choice == OrderMenuConstEnum.values().length) {
                exit = true;
                continue;
            }

            MakeChoice(choice);
        }
    }

    private void MakeChoice(Integer choice) {
        switch (choice) {
            case 1:
                Integer id = reader.getInputInt(scanner, "Enter ID of the order");
                Integer orderNumber = reader.getInputInt(scanner, "Enter the number of the order.");
                Date dateOfArrival = reader.getInputDate(scanner, "Enter the date of arrival (format dd/MM/yyyy).");
                Date dateOfDeparture = reader.getInputDate(scanner, "Enter the date of departure (format dd/MM/yyyy).");
                orderMenu.addOrder(new Order(id, orderNumber, dateOfArrival, dateOfDeparture));
                break;
            case 2:
                printer.print(orderMenu.getListOrders());
                break;
            default: printer.print("Incorrect choice");
        }
    }
}
