package ru.senla.bialevich.menuItems;

import ru.senla.bialevich.controller.ControllerHotelImpl;
import ru.senla.bialevich.menuAction.guestAction.*;
import ru.senla.bialevich.menuAction.guestAction.sort.SortedGuestByDateOfDeparture;
import ru.senla.bialevich.menuAction.guestAction.sort.SortedGuestBySurname;
import ru.senla.bialevich.menuAction.importExportAction.exporter.*;
import ru.senla.bialevich.menuAction.importExportAction.importer.ImportGuests;
import ru.senla.bialevich.menuAction.importExportAction.importer.ImportOrders;
import ru.senla.bialevich.menuAction.importExportAction.importer.ImportRooms;
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
    private static final String MAIN_MENU = "Main menu";
    private static final String EXPORT_MODEL = "Export model";
    private static final String IMPORT_EXPORT = "Import/Export";
    private static final String IMPORT_MODEL = "Import model";

    private Menu rootMenu = new Menu(MAIN_MENU);
    private Menu guestMenu = new Menu(REQUIRED_ACTION);
    private Menu roomMenu = new Menu(REQUIRED_ACTION);
    private Menu orderMenu = new Menu(REQUIRED_ACTION);
    private Menu serviceMenu = new Menu(REQUIRED_ACTION);
    private Menu guestSortMenu = new Menu(SORTING);
    private Menu roomSortMenu = new Menu(SORTING);
    private Menu serviceSortMenu = new Menu(SORTING);
    private Menu importExportMenu = new Menu(IMPORT_EXPORT);
    private Menu importMenu = new Menu(IMPORT_MODEL);
    private Menu exportMenu = new Menu(EXPORT_MODEL);

    public Builder() {
        ControllerHotelImpl.getInstance().init();
    }

    public Menu buildMenu() {

        rootMenu.addMenuItem(new MenuItem("Guests", guestMenu));
        rootMenu.addMenuItem(new MenuItem("Rooms", roomMenu));
        rootMenu.addMenuItem(new MenuItem("Orders", orderMenu));
        rootMenu.addMenuItem(new MenuItem("Used service", serviceMenu));
        rootMenu.addMenuItem(new MenuItem("Import / Export", importExportMenu));
        rootMenu.addMenuItem(new MenuItem("Exit"));

        guestMenu.addMenuItem(new MenuItem("Add guest", new AddGuest(), guestMenu));
        guestMenu.addMenuItem(new MenuItem("Get all guests", new GetAllGuests(), guestMenu));
        guestMenu.addMenuItem(new MenuItem("Get total number of guests", new TotalGuests(), guestMenu));
        guestMenu.addMenuItem(new MenuItem("Get service by guests", new ServiceByGuest(), guestMenu));
        guestMenu.addMenuItem(new MenuItem("Add the room to the guest", new AddRoomToGuest(), guestMenu));
        guestMenu.addMenuItem(new MenuItem("Add the order to the guest", new AddOrderToGuest(), guestMenu));
        guestMenu.addMenuItem(new MenuItem("Sort", guestSortMenu));
        guestMenu.addMenuItem(new MenuItem("Back", rootMenu));

        roomMenu.addMenuItem(new MenuItem("Add room", new AddRoom(), roomMenu));
        roomMenu.addMenuItem(new MenuItem("Clone room", new CloneRoom(), roomMenu));
        roomMenu.addMenuItem(new MenuItem("Register guest in room", new RegisterGuestInRoom(), roomMenu));
        roomMenu.addMenuItem(new MenuItem("Change room status", new ChangeRoomStatus(), roomMenu));
        roomMenu.addMenuItem(new MenuItem("Change price in room", new ChangeRoomPrice(), roomMenu));
        roomMenu.addMenuItem(new MenuItem("Get free rooms", new GetFreeRooms(), roomMenu));
        roomMenu.addMenuItem(new MenuItem("Get total free number of room", new TotalFreeRooms(), roomMenu));
        roomMenu.addMenuItem(new MenuItem("Get room total price", new RoomTotalPrice(), roomMenu));
        roomMenu.addMenuItem(new MenuItem("Get all rooms", new GetAllRooms(), roomMenu));
        roomMenu.addMenuItem(new MenuItem("Add service to the room", new AddServiceToRoom(), roomMenu));
        roomMenu.addMenuItem(new MenuItem("Sort", roomSortMenu));
        roomMenu.addMenuItem(new MenuItem("Back", rootMenu));

        orderMenu.addMenuItem(new MenuItem("Add order", new AddOrder(), orderMenu));
        orderMenu.addMenuItem(new MenuItem("Get order list", new GetOrderList(), orderMenu));
        orderMenu.addMenuItem(new MenuItem("Back", rootMenu));

        serviceMenu.addMenuItem(new MenuItem("Add a new service", new AddService(), serviceMenu));
        serviceMenu.addMenuItem(new MenuItem("Get all used service", new GetAllService(), serviceMenu));
        serviceMenu.addMenuItem(new MenuItem("Sort", serviceSortMenu));
        serviceMenu.addMenuItem(new MenuItem("Back", rootMenu));

        guestSortMenu.addMenuItem(new MenuItem("Sorted guest by surname", new SortedGuestBySurname(), guestSortMenu));
        guestSortMenu.addMenuItem(new MenuItem("Sorted guest by date of departure", new SortedGuestByDateOfDeparture(), guestSortMenu));
        guestSortMenu.addMenuItem(new MenuItem("Back", guestMenu));

        roomSortMenu.addMenuItem(new MenuItem("The list of rooms sorted by price", new SortRoomsByPrice(), roomSortMenu));
        roomSortMenu.addMenuItem(new MenuItem("The list of rooms sorted by capacity", new SortRoomsByBegs(), roomSortMenu));
        roomSortMenu.addMenuItem(new MenuItem("The list of rooms sorted by the number of stars", new SortRoomByStars(), roomSortMenu));
        roomSortMenu.addMenuItem(new MenuItem("The List of free rooms sorted by price", new SortFreeRoomsByPrice(), roomSortMenu));
        roomSortMenu.addMenuItem(new MenuItem("The List of free rooms sorted by capacity", new SortFreeRoomsByBegs(), roomSortMenu));
        roomSortMenu.addMenuItem(new MenuItem("The list of free rooms sorted by the number of stars", new SortFreeRoomsByStars(), roomSortMenu));
        roomSortMenu.addMenuItem(new MenuItem("Back", roomMenu));

        serviceSortMenu.addMenuItem(new MenuItem("Sorted used services by price", new SortServiceByPrice(), serviceSortMenu));
        serviceSortMenu.addMenuItem(new MenuItem("Back", serviceMenu));

        importExportMenu.addMenuItem(new MenuItem("Import", importMenu));
        importExportMenu.addMenuItem(new MenuItem("Export", exportMenu));
        importExportMenu.addMenuItem(new MenuItem("Back", rootMenu));

        importMenu.addMenuItem(new MenuItem("Import guests", new ImportGuests(), importMenu));
        importMenu.addMenuItem(new MenuItem("Import rooms", new ImportRooms(), importMenu));
        importMenu.addMenuItem(new MenuItem("Import orders", new ImportOrders(), importMenu));
        importMenu.addMenuItem(new MenuItem("Back", importExportMenu));

        exportMenu.addMenuItem(new MenuItem("Export guests", new ExportGuests(), exportMenu));
        exportMenu.addMenuItem(new MenuItem("Export rooms", new ExportRooms(), exportMenu));
        exportMenu.addMenuItem(new MenuItem("Export services", new ExportServices(), exportMenu));
        exportMenu.addMenuItem(new MenuItem("Export orders", new ExportOrders(), exportMenu));
        exportMenu.addMenuItem(new MenuItem("Export all", new ExportAll(), exportMenu));
        exportMenu.addMenuItem(new MenuItem("Back", importExportMenu));

        return rootMenu;
    }

    public Menu getRootMenu() {

        return buildMenu();
    }

}
