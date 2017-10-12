package ru.senla.bialevich.menu;

import ru.senla.bialevich.api.RoomMenuController;
import ru.senla.bialevich.api.controller.ControllerHotel;
import ru.senla.bialevich.controller.ControllerHotelImpl;
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
    private ControllerHotel hotel = new ControllerHotelImpl();
    private RoomMenuController roomMenu;

    public RoomMenu(RoomMenuController roomMenu) {
        this.roomMenu = roomMenu;
    }

    public void start() {

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
                printer.print(roomMenu.getRoomTotalPrice(hotel.getRoomById(idRoom)));
                break;
            case 5:
                printer.print(roomMenu.getAllRooms());
                break;
            case 6:
                Integer idRoomS = reader.getInputInt(scanner, "Enter id the room.");
                Integer idService = reader.getInputInt(scanner, "Enter id the used service.");
                roomMenu.addServiceToTheRoom(hotel.getRoomById(idRoomS), hotel.getServiceById(idService));
            case 7:
                RoomSortedMenu roomMenu = new RoomSortedMenu(this.roomMenu);
                roomMenu.start();
            default: printer.print("Incorrect choice");
        }
    }
}
