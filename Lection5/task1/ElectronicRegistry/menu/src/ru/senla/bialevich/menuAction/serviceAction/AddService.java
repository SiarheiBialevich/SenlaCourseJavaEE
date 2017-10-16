package ru.senla.bialevich.menuAction.serviceAction;

import ru.senla.bialevich.api.IAction;
import ru.senla.bialevich.api.controller.ControllerHotel;
import ru.senla.bialevich.controller.ControllerHotelImpl;
import ru.senla.bialevich.entity.UsedService;
import ru.senla.bialevich.util.InputReader;

import java.util.Scanner;

public class AddService implements IAction {

    @Override
    public void execute() {
        ControllerHotel hotel = new ControllerHotelImpl();
        InputReader reader = new InputReader();
        Scanner scanner = new Scanner(System.in);

        Integer id = reader.getInputInt(scanner, "Enter ID of the used service");
        String nameService = reader.getInputString(scanner, "Enter the name of the service.");
        Float price = reader.getInputFloat(scanner, "Enter the price of the service.");
        hotel.addUsedService(new UsedService(id, nameService, price));
    }
}
