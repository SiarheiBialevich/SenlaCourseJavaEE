package ru.senla.bialevich.menu;

import ru.senla.bialevich.api.RoomMenuController;
import ru.senla.bialevich.api.UsedServiceMenuController;
import ru.senla.bialevich.entity.Room;
import ru.senla.bialevich.enums.RoomMenuConstEnum;
import ru.senla.bialevich.menu.sort.RoomSortedMenu;
import ru.senla.bialevich.util.InputReader;
import ru.senla.bialevich.util.Printer;

import java.util.Scanner;

public class RoomMenu {
    private Scanner scanner = new Scanner(System.in);
    private Printer printer = new Printer();
    private InputReader reader = new InputReader();
    private RoomMenuController roomMenu;
    private UsedServiceMenuController serviceMenu;

    public RoomMenu(RoomMenuController roomMenu) {
        this.roomMenu = roomMenu;
    }

    public void start() {

        printer.print("Room menu.");
        printer.print("Select the required action");

        boolean exit = false;

        while (!exit) {
            Integer i = 0;
            for (RoomMenuConstEnum menu : RoomMenuConstEnum.values()) {
                printer.print((i + 1) + ". " + menu.getDescription());
                i++;
            }

            Integer choice = reader.getInputInt(scanner);
            if (choice == RoomMenuConstEnum.values().length) {
                exit = true;
                continue;
            }

            MakeChoice(choice);
        }
    }

    private void MakeChoice(Integer choice) {
        switch (choice) {
            case 1:
                Integer id = reader.getInputInt(scanner, "Enter ID of the room");
                Integer roomNumber = reader.getInputInt(scanner, "Enter the number of the room.");
                Integer countStars = reader.getInputInt(scanner, "Enter the count stars of the room.");
                Integer countOfBeds = reader.getInputInt(scanner, "Enter the count of beds of the room.");
                Float price = reader.getInputFloat(scanner, "Enter the price of the room (separator (,)).");
                roomMenu.addRoom(new Room(id, roomNumber, countStars, countOfBeds, price));
                break;
            case 2:
                printer.print(roomMenu.getFreeRooms());
                break;
            case 3:
                printer.print(roomMenu.getTotalFreeNumberOfRooms());
                break;
            case 4:
                Integer idRoom = reader.getInputInt(scanner, "Enter id the room.");
                printer.print(roomMenu.getRoomTotalPrice(roomMenu.getRoomById(idRoom)));
                break;
            case 5:
                printer.print(roomMenu.getAllRooms());
                break;
            case 6:
                Integer idRoomS = reader.getInputInt(scanner, "Enter id the room.");
                Integer idService = reader.getInputInt(scanner, "Enter id the used service.");
                roomMenu.addServiceToTheRoom(this.roomMenu.getRoomById(idRoomS), serviceMenu.getServiceById(idService));
            case 7:
                RoomSortedMenu roomMenu = new RoomSortedMenu(this.roomMenu);
                roomMenu.start();
            case 8:
//                String filePath = reader.getInputString(scanner, "Enter the path to save the file");
                this.roomMenu.writeToFile("./text/Room.csv", this.roomMenu.getAllRooms());
                break;
            case 9:
//                String filePath = reader.getInputString(scanner, "Enter the path to read from file");
                printer.print(this.roomMenu.readFromFile("./text/Room.csv"));
                break;
            default: printer.print("Incorrect choice");
        }
    }
}
