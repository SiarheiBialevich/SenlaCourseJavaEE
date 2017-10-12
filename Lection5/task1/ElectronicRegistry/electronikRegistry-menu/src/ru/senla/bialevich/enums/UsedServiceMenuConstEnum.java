package ru.senla.bialevich.enums;

public enum UsedServiceMenuConstEnum {
    ADD_NEW_SERVICE("Add a new service"),
    GET_ALL_SERVICE("Get all used service"),
    SORT("Sort"),
    WRITE_SERVICE_TO_FILE("Write list used services to file"),
    READ_SERVICE_FROM_FILE("Read list used services from file"),
    BACK("Back");

    private String description;

    private UsedServiceMenuConstEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
