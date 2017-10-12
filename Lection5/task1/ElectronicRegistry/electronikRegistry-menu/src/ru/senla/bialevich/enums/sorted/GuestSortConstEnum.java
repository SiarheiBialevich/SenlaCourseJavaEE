package ru.senla.bialevich.enums.sorted;

public enum GuestSortConstEnum {
    SORTED_GUEST_BY_SURNAME("Sorted guest by surname"),
    SORTED_GUEST_BY_DATE_OF_DEPARTURE("Sorted guest by date of departure"),
    BACK("Back");

    private String description;

    private GuestSortConstEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
