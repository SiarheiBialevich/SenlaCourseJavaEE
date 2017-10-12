package ru.senla.bialevich.enums;

public enum MainMenuConstEnum {
    WORK_WITH_GUESTS("Guests"),
    WORK_WITH_ROOMS("Rooms"),
    WORK_WITH_ORDERS("Orders"),
    WORK_WITH_SERVICE("Used service"),
    EXIT_MENU("Exit");

    private String description;

    private MainMenuConstEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
