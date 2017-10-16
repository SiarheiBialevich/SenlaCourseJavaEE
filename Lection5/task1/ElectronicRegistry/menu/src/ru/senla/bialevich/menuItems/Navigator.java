package ru.senla.bialevich.menuItems;


import ru.senla.bialevich.util.InputReader;
import ru.senla.bialevich.util.Printer;

import java.util.Scanner;

public class Navigator {


    private Menu currentMenu;

    public void printMenu(Menu currentMenu) {
        Printer printer = new Printer();
        InputReader reader = new InputReader();
        Scanner scanner = new Scanner(System.in);

        this.currentMenu = currentMenu;
        boolean exit = false;
        printer.print(currentMenu.getName());

        while (!exit) {
            for (int i = 0; i < currentMenu.getMenuItems().size(); i++) {
                printer.print((i + 1) + ". " + currentMenu.getMenuItems().get(i).getTitle());
            }

            Integer choice = reader.getInputInt(scanner);

            if (choice > currentMenu.getMenuItems().size()) {
                printer.print("Incorrect choice. Try again");
                continue;
            }

            if (choice == currentMenu.getMenuItems().size()) {
                exit = true;
                continue;
            }

            navigate((choice - 1));
        }

//        scanner.close();
//        printer.print("Bye.");
    }

    public void navigate(Integer index) {

        currentMenu.getMenuItems().get(index).doAction();
    }
}
