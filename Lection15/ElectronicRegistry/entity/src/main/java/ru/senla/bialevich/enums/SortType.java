package ru.senla.bialevich.enums;

public enum SortType {
    id("id"),
    name("name"),
    price("price"),
    rating("rating"),
    capacity("capacity"),
    finalDate("finalDate");

    private String sort;

    SortType(String sort) {
        this.sort = sort;
    }

    public String getSort() {
        return sort;
    }
}
