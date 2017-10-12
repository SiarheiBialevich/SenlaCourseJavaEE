package ru.senla.bialevich.enums;

public enum RoomMenuConstEnum {
    ADD_ROOM("Add room"),
    GET_FREE_ROOMS("Get free rooms"),
    GET_TOTAL_FREE_NUMBER_OF_ROOM("Get total free number of room"),
    GET_ROOM_TOTAL_PRICE("Get room total price"),
    GET_ALL_ROOM("Get all rooms"),
    ROOM_ADD_SERVICE("Add service to the room"),
    SORT("Sort"),
    WRITE_ROOM_TO_FILE("Write list rooms to file"),
    READ_ROOM_FROM_FILE("Read list rooms from file"),
    BACK("Back");

    private String description;

    private RoomMenuConstEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
