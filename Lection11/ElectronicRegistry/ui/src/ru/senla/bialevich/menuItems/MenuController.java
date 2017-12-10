package ru.senla.bialevich.menuItems;

import ru.senla.bialevich.connectordb.ConnectorDb;
import ru.senla.bialevich.request.src.ru.senla.bialevich.IRequestHandler;
import ru.senla.bialevich.util.InputReader;
import ru.senla.bialevich.util.Printer;

import java.util.Scanner;

public class MenuController {
    private Builder builder = new Builder();
    private Navigator navigator = new Navigator();
    private InputReader reader = new InputReader();
    private Printer printer = new Printer();

    private IRequestHandler requestHandler;

    public MenuController(IRequestHandler requestHandler) {
        this.requestHandler = requestHandler;
    }


    public void run() {
        Scanner scanner = new Scanner(System.in);

        boolean exit = false;

        navigator.setCurrentMenu(builder.getRootMenu());
        navigator.printMenu();

        while (!exit) {

            Integer choice = reader.getInputInt(scanner) - 1;

            if (choice >= navigator.getCurrentMenu().getMenuItems().size() || choice < 0) {
                printer.print("Incorrect choice. Try again");
                continue;
            } else {
                navigator.navigate(choice);
            }

            if (navigator.getCurrentMenu().getMenuItems().get(choice).getNextMenu() == null) {
                exit = true;
                continue;
            }

            navigator.setCurrentMenu(navigator.getCurrentMenu().getMenuItems().get(choice).getNextMenu());
            navigator.printMenu();
        }
        scanner.close();
        printer.print("Bye.");

        requestHandler.disconnect();

        ConnectorDb.getInstance().closeConnection();
    }
}
