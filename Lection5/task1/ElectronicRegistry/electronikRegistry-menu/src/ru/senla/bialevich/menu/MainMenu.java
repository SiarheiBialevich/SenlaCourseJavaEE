package ru.senla.bialevich.menu;

import java.util.Scanner;

import ru.senla.bialevich.api.MainMenuController;
import ru.senla.bialevich.enums.MainMenuConstEnum;
import ru.senla.bialevich.util.InputReader;
import ru.senla.bialevich.util.Printer;

public class MainMenu {
    private Scanner scanner = new Scanner(System.in);
    private Printer printer = new Printer();
    private InputReader inputReader = new InputReader();
    private MainMenuController menuController;

    public MainMenu(MainMenuController menuController) {
        this.menuController = menuController;
    }

    public void start() {

        printer.print("Hello.");
        printer.print("Please make your choice.");

        boolean exit = false;

        while (!exit) {
            Integer i = 0;
            for (MainMenuConstEnum menu : MainMenuConstEnum.values()) {
                printer.print((i + 1) + ". " + menu.getDescription());
                i++;
            }

            Integer choice = inputReader.getInputInt(scanner);
            if (choice == MainMenuConstEnum.values().length) {
                exit = true;
                continue;
            }

            MakeChoice(choice);
        }

        scanner.close();
        printer.print("Bye.");
    }

    private void MakeChoice(Integer choice) {
        switch (choice) {
            case 1: menuController.guestsMenu(); break;
            case 2: menuController.roomsMenu(); break;
            case 3: menuController.ordersMenu(); break;
            case 4: menuController.usedServiceMenu(); break;
            default: printer.print("Incorrect choice");
        }
    }
}
