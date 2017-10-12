package ru.senla.bialevich.enums.sorted;

public enum  RoomSortConstEnum {
    ROOMS_SORTED_BY_PRICE("The list of rooms sorted by price"),
    ROOMS_SORTED_BY_CAPACITY("The list of rooms sorted by capacity"),
    ROOMS_SORTED_BY_STARS("The list of rooms sorted by the number of stars"),
    FREE_ROOMS_SORTED_BY_PRICE("The List of free rooms sorted by price"),
    FREE_ROOMS_SORTED_BY_CAPACITY("The List of free rooms sorted by capacity"),
    FREE_ROOMS_SORTED_BY_STARS("The list of free rooms sorted by the number of stars"),
    BACK("Back");

    private String description;

    private RoomSortConstEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
