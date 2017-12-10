package ru.senla.bialevich.enums.entity;

public enum ServicesSection {
    FOOD,
    MANDATORY,
    PLACE;

    public static ServicesSection isExist(String string) {
        for(ServicesSection section : ServicesSection.values()) {
            if(section.toString().equals(string)) {
                return section;
            }
        }
        return null;
    }
}
