package ru.senla.bialevich.util.parser;

import ru.senla.bialevich.entity.Guest;
import ru.senla.bialevich.entity.Registration;
import ru.senla.bialevich.entity.Room;
import ru.senla.bialevich.entity.Service;
import ru.senla.bialevich.enums.entity.RoomSection;
import ru.senla.bialevich.enums.entity.RoomStatus;
import ru.senla.bialevich.enums.entity.ServicesSection;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ParserResultSet {

    public static Guest parseGuest(ResultSet set) {
        Guest guest = new Guest();
        try {
            guest.setId(set.getInt(1));
            guest.setName(set.getString(2));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return guest;
    }

    public static Service parseService(ResultSet set) {
        Service service = new Service();
        try {
            service.setId(set.getInt(1));
            service.setName(set.getString(2));
            service.setPrice(set.getDouble(3));
            service.setSection(ServicesSection.isExist(set.getString(4).toUpperCase()));
            service.setStarDate(set.getDate(5));
            service.setFinalDate(set.getDate(6));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return service;
    }

    public static Room parseRoom(ResultSet set) {
        Room room = new Room();
        try {
            room.setId(set.getInt(1));
            room.setPrice(set.getDouble(2));
            room.setCapacity(set.getInt(3));
            room.setStatus(RoomStatus.isExist(set.getString(4).toUpperCase()));
            room.setSection(RoomSection.isExist(set.getString(5).toUpperCase()));
            room.setRating(set.getInt(6));
            room.setGuests(null);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return room;
    }

    public static Registration parseRegistration(ResultSet set) {
        Registration registration = new Registration();
        try {
            registration.setId(set.getInt(1));
            registration.setGuestId(set.getInt(2));
            registration.setRoomId(set.getInt(3));
            registration.setStartDate(set.getDate(4));
            registration.setFinalDate(set.getDate(5));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return registration;
    }
}
