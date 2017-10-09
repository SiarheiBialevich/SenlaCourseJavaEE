package ru.senla.bialevich.menu;

import ru.senla.bialevich.constant.Constant;
import ru.senla.bialevich.util.Printer;

public class MenuWorker {

    private static final String ADD_NEW_GUEST = Constant.ADD_NEW_GUEST.getDescription();
    private static final String ADD_NEW_ROOM = Constant.ADD_NEW_ROOM.getDescription();
    private static final String ADD_NEW_ORDER = Constant.ADD_NEW_ORDER.getDescription();
    private static final String ADD_NEW_SERVICE = Constant.ADD_NEW_SERVICE.getDescription();
    private static final String ALL_GUEST = Constant.ALL_GUEST.getDescription();
    private static final String FREE_ROOMS = Constant.FREE_ROOMS.getDescription();
    private static final String ROOMS_SORTED_BY_PRICE = Constant.ROOMS_SORTED_BY_PRICE.getDescription();
    private static final String ROOMS_SORTED_BY_CAPACITY = Constant.ROOMS_SORTED_BY_CAPACITY.getDescription();
    private static final String ROOMS_SORTED_BY_STARS = Constant.ROOMS_SORTED_BY_STARS.getDescription();
    private static final String FREE_ROOMS_SORTED_BY_PRICE = Constant.FREE_ROOMS_SORTED_BY_PRICE.getDescription();
    private static final String FREE_ROOMS_SORTED_BY_CAPACITY = Constant.FREE_ROOMS_SORTED_BY_CAPACITY.getDescription();
    private static final String FREE_ROOMS_SORTED_BY_STARS = Constant.FREE_ROOMS_SORTED_BY_STARS.getDescription();
    private static final String TOTAL_PRICE_OF_THE_ROOM = Constant.TOTAL_PRICE_OF_THE_ROOM.getDescription();
    private static final String ADD_ROOM_TO_GUEST = Constant.ADD_ROOM_TO_GUEST.getDescription();
    private static final String ADD_ORDER_TO_GUEST = Constant.ADD_ORDER_TO_GUEST.getDescription();
    private static final String ADD_SERVICE_TO_ROOM = Constant.ADD_SERVICE_TO_ROOM.getDescription();

    private Printer printer = new Printer();

    private String[] menu = new String[16];

    public MenuWorker() {
        createMenu();
    }

    private void createMenu() {
        menu[0] = ADD_NEW_GUEST;
        menu[1] = ADD_NEW_ROOM;
        menu[2] = ADD_NEW_ORDER;
        menu[3] = ADD_NEW_SERVICE;
        menu[4] = ALL_GUEST;
        menu[5] = FREE_ROOMS;
        menu[6] = ROOMS_SORTED_BY_PRICE;
        menu[7] = ROOMS_SORTED_BY_CAPACITY;
        menu[8] = ROOMS_SORTED_BY_STARS;
        menu[9] = FREE_ROOMS_SORTED_BY_PRICE;
        menu[10] = FREE_ROOMS_SORTED_BY_CAPACITY;
        menu[11] = FREE_ROOMS_SORTED_BY_STARS;
        menu[12] = TOTAL_PRICE_OF_THE_ROOM;
        menu[13] = ADD_ROOM_TO_GUEST;
        menu[14] = ADD_ORDER_TO_GUEST;
        menu[15] = ADD_SERVICE_TO_ROOM;
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
