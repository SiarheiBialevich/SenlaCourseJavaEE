package ru.senla.bialevich.util.converter;

import ru.senla.bialevich.entity.Guest;
import ru.senla.bialevich.entity.Order;
import ru.senla.bialevich.entity.Room;
import ru.senla.bialevich.entity.UsedService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class Converter {
    private final String SEPARATOR = ";";

    public Converter() {
    }

    //Converters from object to string

    public String convertGuestToString(Guest guest) {
        StringBuilder sb = new StringBuilder();
        sb.append("Guest");
        sb.append(String.valueOf(guest.getId()));
        sb.append(SEPARATOR);
        sb.append(String.valueOf(guest.getName()));
        sb.append(SEPARATOR);
        sb.append(String.valueOf(guest.getSurname()));
        sb.append(SEPARATOR);

        if (guest.getRoom() == null) {
            sb.append(" ");
        } else {
            sb.append(String.valueOf(guest.getRoom().getId()));
        }

        sb.append(SEPARATOR);

        if (guest.getOrder() == null) {
            sb.append(" ");
        } else {
            sb.append(String.valueOf(guest.getOrder().getId()));
        }

        sb.append(SEPARATOR);

        return sb.toString();
    }

    public String convertRoomToString(Room room) {
        StringBuilder sb = new StringBuilder();
        sb.append("Room");
        sb.append(String.valueOf(room.getId()));
        sb.append(SEPARATOR);
        sb.append(String.valueOf(room.getPrice()));
        sb.append(SEPARATOR);
        sb.append(String.valueOf(room.getCapacity()));
        sb.append(SEPARATOR);
        sb.append(String.valueOf(room.isFree()));
        sb.append(SEPARATOR);
        sb.append(String.valueOf(room.getCountStars()));
        sb.append(SEPARATOR);
        return sb.toString();
    }

    public String convertServiceToString(UsedService service) {
        StringBuilder sb = new StringBuilder();
        sb.append("Service");
        sb.append(String.valueOf(service.getId()));
        sb.append(SEPARATOR);
        sb.append(String.valueOf(service.getNameService()));
        sb.append(SEPARATOR);
        sb.append(String.valueOf(service.getPrice()));
        sb.append(SEPARATOR);
        return sb.toString();
    }

    public String convertOrderToString(Order order) {
        StringBuilder sb = new StringBuilder();
        sb.append("Order");
        sb.append(String.valueOf(order.getId()));
        sb.append(SEPARATOR);
        sb.append(String.valueOf(order.getDateOfArrival()));
        sb.append(SEPARATOR);
        sb.append(String.valueOf(order.getDateOfDeparture()));
        sb.append(SEPARATOR);
        return sb.toString();
    }

    //Converters string to object
    public Guest convertStringToGuest(String string, Map<Integer, Room> roomsMap, Map<Integer, Order> ordersMap) {
        Guest guest = new Guest();
        String[] params = string.split(SEPARATOR);
        Integer id = Integer.parseInt(params[0].replace("[", "").replace("]", "")
                .replace(", ", "").replace("Guest", ""));
        guest.setId(id);

        guest.setName(params[1]);
        guest.setSurname(params[2]);

        if(" ".equals(params[3])) {
            guest.setRoom(null);
        } else {
            guest.setRoom(roomsMap.get(Integer.parseInt(params[3])));
            guest.getRoom().addGuest(guest);
        }
        if(" ".equals(params[4])) {
            guest.setOrder(null);
        } else {
            guest.setOrder(ordersMap.get(Integer.parseInt(params[4])));
            guest.getOrder().addGuest(guest);
        }
        return guest;
    }

    public Room convertStringToRoom(String string) {
        Room room = new Room();
        String[] params = string.split(SEPARATOR);
        room.setId(Integer.parseInt(params[0].replace("[", "").replace("]", "")
                .replace(", ", "").replace("Room", "")));

        room.setPrice(Float.parseFloat(params[1]));
        room.setCapacity(Integer.parseInt(params[2]));
        room.setFree(Boolean.parseBoolean(params[3]));
        room.setCountStars(Integer.parseInt(params[4]));

        return room;
    }

    public UsedService convertStringToService(String string) {
        UsedService serviceModel = new UsedService();
        String[] params = string.split(SEPARATOR);
        serviceModel.setId(Integer.parseInt(params[0].replace("[", "").replace("]", "")
                .replace(", ", "").replace("Service", "")));

        serviceModel.setNameService(params[1]);
        serviceModel.setPrice(Float.parseFloat(params[2]));
        return serviceModel;
    }

    @SuppressWarnings("deprecation")
    public Order convertStringToOrder(String string) {
        Order registrationModel = new Order();
        String[] params = string.split(SEPARATOR);
        registrationModel.setId(Integer.parseInt(params[0].replace("[", "").replace("]", "")
                .replace(", ", "").replace("Order", "")));

        String[] startDates = params[3].split("/");
        registrationModel.setDateOfArrival(new Date(Integer.parseInt(startDates[0]), Integer.parseInt(startDates[1]), Integer.parseInt(startDates[2])));
        String[] finalDates = params[4].split("/");
        registrationModel.setDateOfDeparture(new Date(Integer.parseInt(finalDates[0]), Integer.parseInt(finalDates[1]), Integer.parseInt(finalDates[2])));
        return registrationModel;
    }
}
