package ru.senla.bialevich.util.converter;

import ru.senla.bialevich.model.Guest;
import ru.senla.bialevich.model.Registration;
import ru.senla.bialevich.model.Room;
import ru.senla.bialevich.model.Service;
import ru.senla.bialevich.enums.RoomStatus;
import ru.senla.bialevich.util.converter.api.IConverter;

import java.util.Date;

public class Converter implements IConverter{
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
        sb.append(String.valueOf(room.getStatus()));
        sb.append(SEPARATOR);
        sb.append(String.valueOf(room.getCapacity()));
        sb.append(SEPARATOR);
        return sb.toString();
    }

    public String convertServiceToString(Service service) {
        StringBuilder sb = new StringBuilder();
        sb.append("Service");
        sb.append(String.valueOf(service.getId()));
        sb.append(SEPARATOR);
        sb.append(String.valueOf(service.getName()));
        sb.append(SEPARATOR);
        sb.append(String.valueOf(service.getPrice()));
        sb.append(SEPARATOR);
        return sb.toString();
    }

    public String convertOrderToString(Registration registration) {
        StringBuilder sb = new StringBuilder();
        sb.append("Registration");
        sb.append(String.valueOf(registration.getId()));
        sb.append(SEPARATOR);
        sb.append(String.valueOf(registration.getStartDate()));
        sb.append(SEPARATOR);
        sb.append(String.valueOf(registration.getFinalDate()));
        sb.append(SEPARATOR);
        return sb.toString();
    }

    //Converters string to object
    public Guest convertStringToGuest(String string) {
        Guest guest = new Guest();
        String[] params = string.split(SEPARATOR);
        Integer id = Integer.parseInt(params[0].replace("[", "").replace("]", "")
                .replace(", ", "").replace("Guest", ""));
        guest.setId(id);

        guest.setName(params[1]);
        guest.setSurname(params[2]);

        return guest;
    }


    public Room convertStringToRoom(String string) {
        Room room = new Room();
        String[] params = string.split(SEPARATOR);
        room.setId(Integer.parseInt(params[0].replace("[", "").replace("]", "")
                .replace(", ", "").replace("Room", "")));

        room.setPrice(Double.parseDouble(params[1]));
        room.setCapacity(Integer.parseInt(params[2]));
        room.setStatus(RoomStatus.valueOf(params[3]));
        room.setCapacity(Integer.parseInt(params[4]));

        return room;
    }

    public Service convertStringToService(String string) {
        Service serviceModel = new Service();
        String[] params = string.split(SEPARATOR);
        serviceModel.setId(Integer.parseInt(params[0].replace("[", "").replace("]", "")
                .replace(", ", "").replace("Service", "")));

        serviceModel.setName(params[1]);
        serviceModel.setPrice(Double.parseDouble(params[2]));
        return serviceModel;
    }

    @SuppressWarnings("deprecation")
    public Registration convertStringToRegistration(String string) {
        Registration registrationModel = new Registration();
        String[] params = string.split(SEPARATOR);
        registrationModel.setId(Integer.parseInt(params[0].replace("[", "").replace("]", "")
                .replace(", ", "").replace("Registration", "")));

        String[] startDates = params[3].split("/");
        registrationModel.setStartDate(new Date(Integer.parseInt(startDates[0]), Integer.parseInt(startDates[1]), Integer.parseInt(startDates[2])));
        String[] finalDates = params[4].split("/");
        registrationModel.setFinalDate(new Date(Integer.parseInt(finalDates[0]), Integer.parseInt(finalDates[1]), Integer.parseInt(finalDates[2])));
        return registrationModel;
    }
}
