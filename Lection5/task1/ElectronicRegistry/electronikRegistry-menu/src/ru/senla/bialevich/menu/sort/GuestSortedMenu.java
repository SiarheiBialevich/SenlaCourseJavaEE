package ru.senla.bialevich.menu.sort;

import ru.senla.bialevich.api.GuestMenuController;
import ru.senla.bialevich.enums.sorted.GuestSortConstEnum;
import ru.senla.bialevich.util.InputReader;
import ru.senla.bialevich.util.Printer;

import java.util.Scanner;

public class GuestSortedMenu {
    private Scanner scanner = new Scanner(System.in);
    private Printer printer = new Printer();
    private InputReader reader = new InputReader();
    private GuestMenuController guestMenu;

    public GuestSortedMenu(GuestMenuController guestMenu) {
        this.guestMenu = guestMenu;
    }

    public void start() {

        printer.print("Guest sorted menu.");
        printer.print("Select the required action");

        boolean exit = false;

        while (!exit) {
            Integer i = 0;
            for (GuestSortConstEnum menu : GuestSortConstEnum.values()) {
                printer.print((i + 1) + ". " + menu.getDescription());
                i++;
            }

            Integer choice = reader.getInputInt(scanner);
            if (choice == GuestSortConstEnum.values().length) {
                exit = true;
                continue;
            }

            MakeChoice(choice);
        }

    }

    private void MakeChoice(Integer choice) {
        switch (choice) {
            case 1:
                printer.print(guestMenu.sortedGuestsBySurname());
                break;
            case 2:
                printer.print(guestMenu.sortedGuestsByDateOfDeparture());
                break;
            default: printer.print("Incorrect choice");
        }
    }
}
