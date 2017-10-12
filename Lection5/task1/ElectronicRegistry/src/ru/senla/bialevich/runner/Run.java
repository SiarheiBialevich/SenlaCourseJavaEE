package ru.senla.bialevich.runner;

import ru.senla.bialevich.api.MainMenuController;
import ru.senla.bialevich.controller.MainMenuControllerImpl;
import ru.senla.bialevich.menu.MainMenu;

public class Run {

    public static void main(String[] args) throws Exception {
        MainMenuController menuController = new MainMenuControllerImpl();

        MainMenu menu = new MainMenu(menuController);
        menu.start();
    }
}
