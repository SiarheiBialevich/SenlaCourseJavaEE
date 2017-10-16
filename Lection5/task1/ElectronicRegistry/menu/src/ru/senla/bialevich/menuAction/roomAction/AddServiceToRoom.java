package ru.senla.bialevich.menuAction.roomAction;

import ru.senla.bialevich.api.IAction;
import ru.senla.bialevich.api.controller.ControllerHotel;
import ru.senla.bialevich.controller.ControllerHotelImpl;
import ru.senla.bialevich.util.InputReader;

import java.util.Scanner;

public class AddServiceToRoom implements IAction {

    @Override
    public void execute() {
        ControllerHotel hotel = new ControllerHotelImpl();
        InputReader reader = new InputReader();
        Scanner scanner = new Scanner(System.in);

        Integer idRoom = reader.getInputInt(scanner, "Enter ID the room.");
        Integer idService = reader.getInputInt(scanner, "Enter ID the used service.");
        hotel.setServiceToRoom(hotel.getRoomById(idRoom), hotel.getServiceById(idService));
    }
}
