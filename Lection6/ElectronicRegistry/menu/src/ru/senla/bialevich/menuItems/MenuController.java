package ru.senla.bialevich.menuItems;

import ru.senla.bialevich.controller.ControllerHotelImpl;
import ru.senla.bialevich.util.InputReader;
import ru.senla.bialevich.util.Printer;
import ru.senla.bialevich.util.service.WriteModel;
import ru.senla.bialevich.util.service.WriteObject;

import java.util.Scanner;

public class MenuController {
    private Builder builder = new Builder();
    private Navigator navigator = new Navigator();
    private InputReader reader = new InputReader();
    private Printer printer = new Printer();
    private WriteModel model = new WriteModel();

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

        ControllerHotelImpl.getInstance().exportAll();

        scanner.close();
        printer.print("Bye.");
    }
}
