package ru.senla.bialevich.menuAction.serviceAction;

import ru.senla.bialevich.api.IAction;
import ru.senla.bialevich.entity.UsedService;
import ru.senla.bialevich.menuAction.AbstractAction;
import ru.senla.bialevich.util.InputReader;

import java.util.Scanner;

public class AddService extends AbstractAction implements IAction {

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        String nameService = InputReader.getInputString(scanner, "Enter the name of the services.");
        Float price = InputReader.getInputFloat(scanner, "Enter the price of the services.");
        hotel.addUsedService(new UsedService(nameService, price));
    }
}
