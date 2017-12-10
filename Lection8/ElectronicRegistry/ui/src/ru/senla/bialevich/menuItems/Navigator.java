package ru.senla.bialevich.menuItems;


import ru.senla.bialevich.util.Printer;

public class Navigator {

    private Menu currentMenu;

    public Menu getCurrentMenu() {
        return currentMenu;
    }

    public void setCurrentMenu(Menu currentMenu) {
        this.currentMenu = currentMenu;
    }

    public void printMenu() {
        Printer printer = new Printer();

        printer.print(currentMenu.getName());

        for (int i = 0; i < currentMenu.getMenuItems().size(); i++) {
            printer.print((i + 1) + ". " + currentMenu.getMenuItems().get(i).getTitle());
        }
    }

    public void navigate(Integer index) {
        if (currentMenu.getMenuItems().get(index).getAction() != null) {
            currentMenu.getMenuItems().get(index).doAction();
        } else {
            currentMenu.getMenuItems().get(index).getNextMenu();
        }
    }
}
