package ru.senla.bialevich.enums;

public enum  OrderMenuConstEnum {
    ADD_ORDER("Add order"),
    GET_ORDER_LIST("Get order list"),
    WRITE_ORDER_TO_FILE("Write list orders to file"),
    READ_ORDER_FROM_FILE("Read list orders from file"),
    BACK("Back");

    private String description;

    private OrderMenuConstEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
