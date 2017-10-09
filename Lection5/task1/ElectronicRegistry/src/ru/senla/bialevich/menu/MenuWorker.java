package ru.senla.bialevich.menu;

import ru.senla.bialevich.enums.MenuConstEnum;
import ru.senla.bialevich.util.Printer;

public class MenuWorker {

    private Printer printer = new Printer();

    private String[] menu = new String[16];

    public MenuWorker() {
        createMenu();
    }

    private void createMenu() {
        menu[0] = MenuConstEnum.ADD_NEW_GUEST.getDescription();
        menu[1] = MenuConstEnum.ADD_NEW_ROOM.getDescription();
        menu[2] = MenuConstEnum.ADD_NEW_ORDER.getDescription();
        menu[3] = MenuConstEnum.ADD_NEW_SERVICE.getDescription();
        menu[4] = MenuConstEnum.ALL_GUEST.getDescription();
        menu[5] = MenuConstEnum.FREE_ROOMS.getDescription();
        menu[6] = MenuConstEnum.ROOMS_SORTED_BY_PRICE.getDescription();
        menu[7] = MenuConstEnum.ROOMS_SORTED_BY_CAPACITY.getDescription();
        menu[8] = MenuConstEnum.ROOMS_SORTED_BY_STARS.getDescription();
        menu[9] = MenuConstEnum.FREE_ROOMS_SORTED_BY_PRICE.getDescription();
        menu[10] = MenuConstEnum.FREE_ROOMS_SORTED_BY_CAPACITY.getDescription();
        menu[11] = MenuConstEnum.FREE_ROOMS_SORTED_BY_STARS.getDescription();
        menu[12] = MenuConstEnum.TOTAL_PRICE_OF_THE_ROOM.getDescription();
        menu[13] = MenuConstEnum.ADD_ROOM_TO_GUEST.getDescription();
        menu[14] = MenuConstEnum.ADD_ORDER_TO_GUEST.getDescription();
        menu[15] = MenuConstEnum.ADD_SERVICE_TO_ROOM.getDescription();
    }

    public void printMenu() {
        for (int i = 0; i < menu.length; i++) {
            printer.print((i + 1) + ". " + menu[i]);
        }
    }

    public Integer getMenuIndex(Integer numberChoise) {
        Integer index = numberChoise - 1;

        if (index >= 0 && index < menu.length) {
            return index;
        } else {
            return -1;
        }
    }
}
