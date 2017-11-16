package ru.senla.bialevich.enums.entity;

public enum Services {
    FOOD,
    MANDATORY,
    PLACE;

    public static Services isExist(String string) {
        for(Services section : Services.values()) {
            if(section.toString().equals(string)) {
                return section;
            }
        }
        return null;
    }
}
