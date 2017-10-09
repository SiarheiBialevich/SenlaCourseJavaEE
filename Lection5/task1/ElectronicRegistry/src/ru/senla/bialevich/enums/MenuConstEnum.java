package ru.senla.bialevich.enums;

public enum MenuConstEnum {
    ADD_NEW_GUEST("To add a new guest"),
    ADD_NEW_ROOM("To add a new room"),
    ADD_NEW_ORDER("To add a new order"),
    ADD_NEW_SERVICE("To add a new service"),
    ALL_GUEST("Show a list of all the guest"),
    FREE_ROOMS("Show a list of free rooms"),
    ROOMS_SORTED_BY_PRICE("The list of rooms sorted by price"),
    ROOMS_SORTED_BY_CAPACITY("The list of rooms sorted by capacity"),
    ROOMS_SORTED_BY_STARS("The list of rooms sorted by the number of stars"),
    FREE_ROOMS_SORTED_BY_PRICE("The List of free rooms sorted by price"),
    FREE_ROOMS_SORTED_BY_CAPACITY("The List of free rooms sorted by capacity"),
    FREE_ROOMS_SORTED_BY_STARS("The list of free rooms sorted by the number of stars"),
    TOTAL_PRICE_OF_THE_ROOM("Show the payment amount for the room"),
    ADD_ROOM_TO_GUEST("To add a room to a guest"),
    ADD_ORDER_TO_GUEST("To add a order to a guest"),
    ADD_SERVICE_TO_ROOM("To add a order to a guest"),
    ID_THE_GUEST("Enter id the guest."),
    ID_THE_ROOM("Enter id the room."),
    ID_THE_ORDER("Enter id the order."),
    ID_THE_SERVICE("Enter id the service.");

    private String description;

    private MenuConstEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
