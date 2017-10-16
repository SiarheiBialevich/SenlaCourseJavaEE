package ru.senla.bialevich.menuItems;

public class MenuController {
    private Builder builder = new Builder();
    private Navigator navigator = new Navigator();

    public void run() {

        navigator.printMenu(builder.MainMenu());
    }
}
