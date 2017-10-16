package ru.senla.bialevich.menuItems;

import ru.senla.bialevich.menuAction.*;
import ru.senla.bialevich.menuAction.guestAction.*;
import ru.senla.bialevich.menuAction.guestAction.sort.SortedGuestByDateOfDeparture;
import ru.senla.bialevich.menuAction.guestAction.sort.SortedGuestBySurname;
import ru.senla.bialevich.menuAction.orderAction.AddOrder;
import ru.senla.bialevich.menuAction.orderAction.GetOrderList;
import ru.senla.bialevich.menuAction.roomAction.*;
import ru.senla.bialevich.menuAction.roomAction.sort.*;
import ru.senla.bialevich.menuAction.serviceAction.AddService;
import ru.senla.bialevich.menuAction.serviceAction.GetAllService;
import ru.senla.bialevich.menuAction.serviceAction.sort.SortServiceByPrice;

public class Builder {
    private static final String REQUIRED_ACTION = "Select the required menuAction:";
    private static final String SORTING = "Select sorting:";
    private Menu rootMenu;
    private Navigator navigator = new Navigator();

    public Menu MainMenu() {
        rootMenu = new Menu("Main menu");

        rootMenu.addMenuItem(new MenuItem("Guests", new GuestMenu()));
        rootMenu.addMenuItem(new MenuItem("Rooms", new RoomMenu()));
        rootMenu.addMenuItem(new MenuItem("Orders", new OrderMenu()));
        rootMenu.addMenuItem(new MenuItem("Used service", new ServiceMenu()));
        rootMenu.addMenuItem(new MenuItem("Exit"));

        return rootMenu;
    }

    public void GuestMenu() {

        rootMenu = new Menu(REQUIRED_ACTION);

        rootMenu.addMenuItem(new MenuItem("Add guest", new AddGuest()));
        rootMenu.addMenuItem(new MenuItem("Get all guests", new GetAllGuests()));
        rootMenu.addMenuItem(new MenuItem("Get total number of guests", new TotalGuests()));
        rootMenu.addMenuItem(new MenuItem("Get service by guests", new ServiceByGuest()));
        rootMenu.addMenuItem(new MenuItem("Add the room to the guest", new AddRoomToGuest()));
        rootMenu.addMenuItem(new MenuItem("Add the order to the guest", new AddOrderToGuest()));
        rootMenu.addMenuItem(new MenuItem("Sort", new GuestSortMenu()));
        rootMenu.addMenuItem(new MenuItem("Back", getRootMenu()));

        navigator.printMenu(rootMenu);
    }

    public void RoomMenu() {

        rootMenu = new Menu(REQUIRED_ACTION);

        rootMenu.addMenuItem(new MenuItem("Add room", new AddRoom()));
        rootMenu.addMenuItem(new MenuItem("Get free rooms", new GetFreeRooms()));
        rootMenu.addMenuItem(new MenuItem("Get total free number of room", new TotalFreeRooms()));
        rootMenu.addMenuItem(new MenuItem("Get room total price", new RoomTotalPrice()));
        rootMenu.addMenuItem(new MenuItem("Get all rooms", new GetAllRooms()));
        rootMenu.addMenuItem(new MenuItem("Add service to the room", new AddServiceToRoom()));
        rootMenu.addMenuItem(new MenuItem("Sort", new RoomSortMenu()));
        rootMenu.addMenuItem(new MenuItem("Back", getRootMenu()));

        navigator.printMenu(rootMenu);
    }

    public void OrderMenu() {

        rootMenu = new Menu(REQUIRED_ACTION);

        rootMenu.addMenuItem(new MenuItem("Add order", new AddOrder()));
        rootMenu.addMenuItem(new MenuItem("Get order list", new GetOrderList()));
        rootMenu.addMenuItem(new MenuItem("Back", getRootMenu()));

        navigator.printMenu(rootMenu);
    }

    public void ServiceMenu() {

        rootMenu = new Menu(REQUIRED_ACTION);

        rootMenu.addMenuItem(new MenuItem("Add a new service", new AddService()));
        rootMenu.addMenuItem(new MenuItem("Get all used service", new GetAllService()));
        rootMenu.addMenuItem(new MenuItem("Sort", new ServiceSortMenu()));
        rootMenu.addMenuItem(new MenuItem("Back", getRootMenu()));

        navigator.printMenu(rootMenu);
    }

    public void GuestSortMenu() {
        rootMenu = new Menu(SORTING);

        rootMenu.addMenuItem(new MenuItem("Sorted guest by surname", new SortedGuestBySurname()));
        rootMenu.addMenuItem(new MenuItem("Sorted guest by date of departure", new SortedGuestByDateOfDeparture()));
        rootMenu.addMenuItem(new MenuItem("Back", getRootMenu()));

        navigator.printMenu(rootMenu);
    }

    public void RoomSortMenu() {
        rootMenu = new Menu(SORTING);

        rootMenu.addMenuItem(new MenuItem("The list of rooms sorted by price", new SortRoomsByPrice()));
        rootMenu.addMenuItem(new MenuItem("The list of rooms sorted by capacity", new SortRoomsByBegs()));
        rootMenu.addMenuItem(new MenuItem("The list of rooms sorted by the number of stars", new SortRoomByStars()));
        rootMenu.addMenuItem(new MenuItem("The List of free rooms sorted by price", new SortFreeRoomsByPrice()));
        rootMenu.addMenuItem(new MenuItem("The List of free rooms sorted by capacity", new SortFreeRoomsByBegs()));
        rootMenu.addMenuItem(new MenuItem("The list of free rooms sorted by the number of stars", new SortFreeRoomsByStars()));
        rootMenu.addMenuItem(new MenuItem("Back", getRootMenu()));

        navigator.printMenu(rootMenu);
    }

    public void ServiceSortMenu() {
        rootMenu = new Menu(SORTING);

        rootMenu.addMenuItem(new MenuItem("Sorted used services by price", new SortServiceByPrice()));
        rootMenu.addMenuItem(new MenuItem("Back", getRootMenu()));

        navigator.printMenu(rootMenu);
    }

    public Menu getRootMenu() {

        return rootMenu;
    }

}
