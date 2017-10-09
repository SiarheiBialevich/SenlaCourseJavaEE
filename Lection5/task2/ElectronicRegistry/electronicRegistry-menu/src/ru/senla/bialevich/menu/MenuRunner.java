package ru.senla.bialevich.menu;

import ru.senla.bialevich.menu.action.ActionRunner;
import ru.senla.bialevich.util.InputReader;
import ru.senla.bialevich.util.Printer;

import java.util.Scanner;

public class MenuRunner {
    private Scanner scanner = new Scanner(System.in);

    private MenuWorker menuWorker = new MenuWorker();

    private ActionRunner actionRunner = new ActionRunner();

    private Printer printer = new Printer();

    private InputReader inputReader = new InputReader();

    public void start() {
        printer.print("Hello.");

        boolean exit = false;

        while (!exit) {
            printer.print("Please make your choice. For exit press 0");
            menuWorker.printMenu();

            Integer choice = inputReader.getInputInt(scanner);
            if (choice == 0) {
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
            case 1: actionRunner.runAddANewGuest(scanner); break;
            case 2: actionRunner.runAddANewRoom(scanner); break;
            case 3: actionRunner.runAddNewOrder(scanner); break;
            case 4: actionRunner.runAddNewService(scanner); break;
            case 5: actionRunner.runGetAllGuest(); break;
            case 6: actionRunner.runGetAllFreeRooms(); break;
            case 7: actionRunner.runGetAllRoomsSortedByPrice(); break;
            case 8: actionRunner.runGetAllRoomsSortedByCapacity(); break;
            case 9: actionRunner.runGetAllRoomsSortedByCountOfStars(); break;
            case 10: actionRunner.runGetAllFreeRoomsSortedByPrice(); break;
            case 11: actionRunner.runGetAllFreeRoomsSortedByCapacity(); break;
            case 12: actionRunner.runGetAllFreeRoomsSortedByCountOfStars(); break;
            case 13: actionRunner.runShowTotalPriceOfTheRoom(scanner); break;
            case 14: actionRunner.runAddRoomFromAGuest(scanner); break;
            case 15: actionRunner.runAddOrderFromAGuest(scanner); break;
            case 16: actionRunner.runAddServiceFromARoom(scanner); break;
            default: printer.print("Incorrect choice");

        }
    }
}
