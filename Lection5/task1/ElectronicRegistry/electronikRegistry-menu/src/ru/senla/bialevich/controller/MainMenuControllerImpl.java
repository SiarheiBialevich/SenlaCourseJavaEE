package ru.senla.bialevich.controller;

import ru.senla.bialevich.api.*;
import ru.senla.bialevich.menu.GuestMenu;
import ru.senla.bialevich.menu.OrderMenu;
import ru.senla.bialevich.menu.RoomMenu;
import ru.senla.bialevich.menu.UsedServiceMenu;

public class MainMenuControllerImpl implements MainMenuController {

    private GuestMenuController guestMenu = new GuestMenuControllerImpl();
    private RoomMenuController roomMenu = new RoomMenuControllerImpl();
    private OrderMenuController orderMenu = new OrderMenuControllerImpl();
    private UsedServiceMenuController serviceMenu = new UsedServiceMenuControllerImpl();

    @Override
    public void guestsMenu() {
        GuestMenu guestMenu = new GuestMenu(this.guestMenu);
        guestMenu.start();
    }

    @Override
    public void roomsMenu() {
        RoomMenu roomMenu = new RoomMenu(this.roomMenu);
        roomMenu.start();
    }

    @Override
    public void ordersMenu() {
        OrderMenu orderMenu = new OrderMenu(this.orderMenu);
        orderMenu.start();
    }

    @Override
    public void usedServiceMenu() {
        UsedServiceMenu serviceMenu = new UsedServiceMenu(this.serviceMenu);
        serviceMenu.start();
    }
}
