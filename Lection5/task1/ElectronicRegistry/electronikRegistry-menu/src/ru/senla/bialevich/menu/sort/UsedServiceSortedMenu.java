package ru.senla.bialevich.menu.sort;

import ru.senla.bialevich.api.UsedServiceMenuController;
import ru.senla.bialevich.enums.sorted.UsedServiceSortConstEnum;
import ru.senla.bialevich.util.InputReader;
import ru.senla.bialevich.util.Printer;

import java.util.Scanner;

public class UsedServiceSortedMenu {
    private Scanner scanner = new Scanner(System.in);
    private Printer printer = new Printer();
    private InputReader reader = new InputReader();
    private UsedServiceMenuController serviceMenu;

    public UsedServiceSortedMenu(UsedServiceMenuController serviceMenu) {
        this.serviceMenu = serviceMenu;
    }

    public void start() {

        printer.print("Select the required action");

        boolean exit = false;

        while (!exit) {
            Integer i = 0;
            for (UsedServiceSortConstEnum menu : UsedServiceSortConstEnum.values()) {
                printer.print((i + 1) + ". " + menu.getDescription());
                i++;
            }

            Integer choice = reader.getInputInt(scanner);
            if (choice == UsedServiceSortConstEnum.values().length) {
                exit = true;
                continue;
            }

            MakeChoice(choice);
        }

    }

    private void MakeChoice(Integer choice) {
        switch (choice) {
            case 1:
                printer.print(serviceMenu.sortUsedServicesByPrice());
                break;
            default: printer.print("Incorrect choice");
        }
    }
}
