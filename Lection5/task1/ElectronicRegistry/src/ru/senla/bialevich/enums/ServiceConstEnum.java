package ru.senla.bialevich.enums;

public enum ServiceConstEnum {
    TOTAL_GUEST("Total number of guests"),
    SORTED_GUEST_BY_SYRNAME("Sorted guest by surname"),
    SORTED_GUEST_BY_DATE_OF_DEPARTURE("Sorted guest by date of departure"),
    SORTED_ROOMS_BY_PRICE("Sorted rooms by price"),
    SORTED_ROOMS_BY_COUNT_BEGS("Sorted rooms by count begs"),
    SORTED_ROOMS_BY_CATEGORY("Sorted rooms by category"),
    SORTED_FREE_ROOMS_BY_PRICE("Sorted free rooms by price"),
    SORTED_FREE_ROOMS_BY_COUNT_BEGS("Sorted free rooms by count begs"),
    SORTED_FREE_ROOMS_BY_COUNT_CATEGORY("Sorted free rooms by category"),
    GET_FREE_ROOMS("Get free rooms"),
    GET_TOTAL_FREE_ROOMS("Total free rooms"),
    GET_ALL_ROOMS("All rooms"),
    GET_TOTAL_PRICE_ROOMS("Total price room "),
    SORTED_SERVICE_BY_PRICE("Sorted used services by price");

    private String description;

    private ServiceConstEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
