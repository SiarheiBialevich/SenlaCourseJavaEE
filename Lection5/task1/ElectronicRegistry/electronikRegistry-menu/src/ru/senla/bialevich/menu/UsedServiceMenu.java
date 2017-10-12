package ru.senla.bialevich.menu;

import ru.senla.bialevich.api.UsedServiceMenuController;
import ru.senla.bialevich.entity.UsedService;
import ru.senla.bialevich.enums.UsedServiceMenuConstEnum;
import ru.senla.bialevich.menu.sort.UsedServiceSortedMenu;
import ru.senla.bialevich.util.InputReader;
import ru.senla.bialevich.util.Printer;

import java.util.Scanner;

public class UsedServiceMenu {
    private Scanner scanner = new Scanner(System.in);
    private Printer printer = new Printer();
    private InputReader reader = new InputReader();
    private UsedServiceMenuController serviceMenu;

    public UsedServiceMenu(UsedServiceMenuController serviceMenu) {
        this.serviceMenu = serviceMenu;
    }

    public void start() {

        printer.print("Used service menu.");
        printer.print("Select the required action");

        boolean exit = false;

        while (!exit) {
            Integer i = 0;
            for (UsedServiceMenuConstEnum menu : UsedServiceMenuConstEnum.values()) {
                printer.print((i + 1) + ". " + menu.getDescription());
                i++;
            }

            Integer choice = reader.getInputInt(scanner);
            if (choice == UsedServiceMenuConstEnum.values().length) {
                exit = true;
                continue;
            }

            MakeChoice(choice);
        }
    }

    private void MakeChoice(Integer choice) {
        switch (choice) {
            case 1:
                Integer id = reader.getInputInt(scanner, "Enter ID of the used service");
                String nameService = reader.getInputString(scanner, "Enter the name of the service.");
                Float price = reader.getInputFloat(scanner, "Enter the price of the service.");
                serviceMenu.addUsedService(new UsedService(id, nameService, price));
                break;
            case 2:
                printer.print(serviceMenu.getListUsedServices());
                break;
            case 3:
                UsedServiceSortedMenu serviceMenu = new UsedServiceSortedMenu(this.serviceMenu);
                serviceMenu.start();
            case 4:
//                String filePath = reader.getInputString(scanner, "Enter the path to save the file");
                this.serviceMenu.writeToFile("./text/Service.csv", this.serviceMenu.getListUsedServices());
                break;
            case 5:
//                String filePath = reader.getInputString(scanner, "Enter the path to save the file");
                printer.print(this.serviceMenu.readFromFile("./text/Service.csv"));
                break;
            default: printer.print("Incorrect choice");
        }
    }
}
