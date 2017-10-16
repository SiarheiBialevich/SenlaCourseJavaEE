package ru.senla.bialevich.runner;

import ru.senla.bialevich.menuItems.MenuController;

public class Run {


    public static void main(String[] args) {
//        Menu rootMenu = new Menu();
//        Builder builder = new Builder();
//        Navigator navigator = new Navigator();

//        builder.MainMenu();

//        navigator.printMenu();

        MenuController controller = new MenuController();
        controller.run();
    }

}
