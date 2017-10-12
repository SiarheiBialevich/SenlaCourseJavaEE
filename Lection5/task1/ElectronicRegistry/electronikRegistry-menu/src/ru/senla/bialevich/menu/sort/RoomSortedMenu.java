package ru.senla.bialevich.menu.sort;

import ru.senla.bialevich.api.RoomMenuController;
import ru.senla.bialevich.enums.sorted.RoomSortConstEnum;
import ru.senla.bialevich.util.InputReader;
import ru.senla.bialevich.util.Printer;

import java.util.Scanner;

public class RoomSortedMenu {
    private Scanner scanner = new Scanner(System.in);
    private Printer printer = new Printer();
    private InputReader reader = new InputReader();
    private RoomMenuController roomMenu;

    public RoomSortedMenu(RoomMenuController roomMenu) {
        this.roomMenu = roomMenu;
    }

    public void start() {

        printer.print("Select the required action");

        boolean exit = false;

        while (!exit) {
            Integer i = 0;
            for (RoomSortConstEnum menu : RoomSortConstEnum.values()) {
                printer.print((i + 1) + ". " + menu.getDescription());
                i++;
            }

            Integer choice = reader.getInputInt(scanner);
            if (choice == RoomSortConstEnum.values().length) {
                exit = true;
                continue;
            }

            MakeChoice(choice);
        }

    }

    private void MakeChoice(Integer choice) {
        switch (choice) {
            case 1:
                printer.print(roomMenu.sortedRoomsByPrice());
                break;
            case 2:
                printer.print(roomMenu.sortedRoomsByCountBegs());
                break;
            case 3:
                printer.print(roomMenu.sortedRoomsByCategory());
                break;
            case 4:
                printer.print(roomMenu.sortedFreeRoomsByPrice());
                break;
            case 5:
                printer.print(roomMenu.sortedFreeRoomsByCountBegs());
                break;
            case 6:
                printer.print(roomMenu.sortedFreeRoomsByCategory());
                break;
            default: printer.print("Incorrect choice");
        }
    }
}
