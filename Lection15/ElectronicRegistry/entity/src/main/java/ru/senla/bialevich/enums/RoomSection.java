package ru.senla.bialevich.enums;

public enum RoomSection {
    SINGLE,
    STANDART,
    IMPROVED,
    LUKS;

    public static RoomSection isExist(String string) {
        for(RoomSection section : RoomSection.values()) {
            if(section.toString().equals(string)) {
                return section;
            }
        }
        return null;
    }
}
