package ru.senla.bialevich.menuAction.roomAction;

import ru.senla.bialevich.api.IAction;
import ru.senla.bialevich.api.controller.ControllerHotel;
import ru.senla.bialevich.controller.ControllerHotelImpl;
import ru.senla.bialevich.entity.Room;
import ru.senla.bialevich.util.InputReader;

import java.util.Scanner;

public class AddRoom implements IAction {

    @Override
    public void execute() {
        ControllerHotel hotel = new ControllerHotelImpl();
        InputReader reader = new InputReader();
        Scanner scanner = new Scanner(System.in);

        Integer id = reader.getInputInt(scanner, "Enter ID of the room");
        Integer roomNumber = reader.getInputInt(scanner, "Enter the number of the room.");
        Integer countStars = reader.getInputInt(scanner, "Enter the count stars of the room.");
        Integer countOfBeds = reader.getInputInt(scanner, "Enter the count of beds of the room.");
        Float price = reader.getInputFloat(scanner, "Enter the price of the room.");

        hotel.addRoom(new Room(id, roomNumber, countStars, countOfBeds, price));
    }
}
