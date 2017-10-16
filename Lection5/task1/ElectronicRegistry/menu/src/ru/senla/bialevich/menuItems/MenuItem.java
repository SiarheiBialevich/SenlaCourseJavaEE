package ru.senla.bialevich.menuItems;

import ru.senla.bialevich.api.IAction;

public class MenuItem {
    private String title;
    private IAction action;
    private Menu rootMenu;

    public MenuItem(String title) {
        this.title = title;
    }

    public MenuItem(String title, IAction action) {
        this.title = title;
        this.action = action;
    }

    public MenuItem(String title, Menu rootMenu) {
        this.title = title;
        this.rootMenu = rootMenu;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public IAction getAction() {
        return action;
    }

    public void setAction(IAction action) {
        this.action = action;
    }

    public Menu getRootMenu() {
        return rootMenu;
    }

    public void setRootMenu(Menu rootMenu) {
        this.rootMenu = rootMenu;
    }

    void doAction() {
        getAction().execute();
    }
}