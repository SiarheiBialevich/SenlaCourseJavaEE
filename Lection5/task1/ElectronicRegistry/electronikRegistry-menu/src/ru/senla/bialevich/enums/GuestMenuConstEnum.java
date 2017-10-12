package ru.senla.bialevich.enums;

public enum  GuestMenuConstEnum {
    ADD_GUEST("Add guest"),
    GET_ALL_GUESTS("Get all guests"),
    GET_TOTAL_NUMBER_OF_GUESTS("Get total number of guests"),
    GET_SERVICE_BY_GUESTS("Get service by guests"),
    GUEST_SET_ROOM("Add the room to the guest"),
    GUEST_SET_ORDER("Add the order to the guest"),
    SORT("Sort"),
    WRITE_GUEST_TO_FILE("Write list guests to file"),
    READ_GUEST_FROM_FILE("Read list guests from file"),
    BACK("Back");

    private String description;

    private GuestMenuConstEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
