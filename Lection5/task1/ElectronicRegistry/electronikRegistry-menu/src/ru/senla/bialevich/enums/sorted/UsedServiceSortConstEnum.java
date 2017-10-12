package ru.senla.bialevich.enums.sorted;

public enum UsedServiceSortConstEnum {
    SORTED_SERVICE_BY_PRICE("Sorted used services by price"),
    BACK("Back");

    private String description;

    private UsedServiceSortConstEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
