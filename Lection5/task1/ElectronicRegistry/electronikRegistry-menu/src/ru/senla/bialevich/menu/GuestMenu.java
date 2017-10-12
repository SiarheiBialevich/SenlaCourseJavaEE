package ru.senla.bialevich.menu;

import ru.senla.bialevich.api.GuestMenuController;
import ru.senla.bialevich.api.OrderMenuController;
import ru.senla.bialevich.api.RoomMenuController;
import ru.senla.bialevich.entity.Guest;
import ru.senla.bialevich.enums.GuestMenuConstEnum;
import ru.senla.bialevich.menu.sort.GuestSortedMenu;
import ru.senla.bialevich.util.InputReader;
import ru.senla.bialevich.util.Printer;

import java.util.Scanner;

public class GuestMenu {
    private Scanner scanner = new Scanner(System.in);
    private Printer printer = new Printer();
    private InputReader reader = new InputReader();
    private GuestMenuController guestMenu;
    private RoomMenuController roomMenu;
    private OrderMenuController orderMenu;

    public GuestMenu(GuestMenuController guestMenu) {
        this.guestMenu = guestMenu;
    }

    public void start() {

        printer.print("Guest menu.");
        printer.print("Select the required action");

        boolean exit = false;

        while (!exit) {
            Integer i = 0;
            for (GuestMenuConstEnum menu : GuestMenuConstEnum.values()) {
                printer.print((i + 1) + ". " + menu.getDescription());
                i++;
            }

            Integer choice = reader.getInputInt(scanner);
            if (choice == GuestMenuConstEnum.values().length) {
                exit = true;
                continue;
            }

            MakeChoice(choice);
        }
    }

    private void MakeChoice(Integer choice) {
        switch (choice) {
            case 1:
                Integer id = reader.getInputInt(scanner, "Enter id the guest.");
                String name = reader.getInputString(scanner, "Enter the name of the guest.");
                String surname = reader.getInputString(scanner, "Enter the surname of the guest.");
                guestMenu.addGuest(new Guest(id, name, surname));
                break;
            case 2:
                printer.print(guestMenu.getAllGuest());
                break;
            case 3:
                printer.print(guestMenu.getTotalNumberOfGuests());
                break;
            case 4:
                Integer idGuest = reader.getInputInt(scanner, "Enter id the guest.");
                printer.print(guestMenu.getServiceByGuest(this.guestMenu.getGuestById(idGuest)));
                break;
            case 5:
                Integer idGuestR = reader.getInputInt(scanner, "Enter id the guest.");
                Integer idRoom = reader.getInputInt(scanner, "Enter id the room.");
                guestMenu.addRoomToTheGuest(this.guestMenu.getGuestById(idGuestR), roomMenu.getRoomById(idRoom));
            case 6:
                Integer idGuestO = reader.getInputInt(scanner, "Enter id the guest.");
                Integer idOrder = reader.getInputInt(scanner, "Enter id the order.");
                guestMenu.addOrderToTheGuest(this.guestMenu.getGuestById(idGuestO), orderMenu.getOrderById(idOrder));
            case 7:
                GuestSortedMenu guestMenu = new GuestSortedMenu(this.guestMenu);
                guestMenu.start();
            case 8:
//                String filePath = reader.getInputString(scanner, "Enter the path to save the file");
                this.guestMenu.writeToFile("./text/Guest.csv", this.guestMenu.getAllGuest());
                break;
            case 9:
//                String filePath = reader.getInputString(scanner, "Enter the path to read from file");
                printer.print(this.guestMenu.readFromFile("./text/Guest.csv"));
                break;
            default:
                printer.print("Incorrect choice");
        }
    }
}
