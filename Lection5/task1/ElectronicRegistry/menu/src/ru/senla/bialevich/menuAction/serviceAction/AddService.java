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
        Scanner scanner = new Scanner(System.in);

        Integer id = InputReader.getInputInt(scanner, "Enter ID of the used service");
        String nameService = InputReader.getInputString(scanner, "Enter the name of the service.");
        Float price = InputReader.getInputFloat(scanner, "Enter the price of the service.");
        ControllerHotelImpl.getInstance().addUsedService(new UsedService(id, nameService, price));
    }
}
