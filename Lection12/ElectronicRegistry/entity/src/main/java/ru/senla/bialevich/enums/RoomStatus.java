package ru.senla.bialevich.enums;

public enum RoomStatus {
    MAINTAINED,
    FREE,
    BUSY;

    public static RoomStatus isExist(String string) {
        for(RoomStatus status : RoomStatus.values()) {
            if(status.toString().equals(string)) {
                return status;
            }
        }
        return null;
    }
}
