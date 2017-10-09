package ru.senla.bialevich.menu.action;

import ru.senla.bialevich.api.controller.ControllerHotel;
import ru.senla.bialevich.enums.MenuConstEnum;
import ru.senla.bialevich.controller.ControllerHotelImpl;
import ru.senla.bialevich.entity.Guest;
import ru.senla.bialevich.entity.Order;
import ru.senla.bialevich.entity.Room;
import ru.senla.bialevich.entity.UsedService;
import ru.senla.bialevich.util.InputReader;

import java.util.Date;
import java.util.Scanner;

public class ActionRunner {

    private ControllerHotel hotel = new ControllerHotelImpl();
    private InputReader reader = new InputReader();

    public void runAddANewGuest(Scanner scanner) {
        Integer id = reader.getInputInt(scanner, MenuConstEnum.ID_THE_GUEST.getDescription());
        String name = reader.getInputString(scanner, "Enter the name of the guest.");
        String surname = reader.getInputString(scanner, "Enter the surname of the guest.");

        hotel.addGuest(new Guest(id, name, surname));
    }

    public void runAddANewRoom(Scanner scanner) {
        Integer id = reader.getInputInt(scanner, MenuConstEnum.ID_THE_ROOM.getDescription());
        Integer roomNumber = reader.getInputInt(scanner, "Enter the number of the room.");
        Integer countStars = reader.getInputInt(scanner, "Enter the count stars of the room.");
        Integer countOfBeds = reader.getInputInt(scanner, "Enter the count of beds of the room.");
        Float price = reader.getInputFloat(scanner, "Enter the price of the room (separator (,)).");

        hotel.addRoom(new Room(id, roomNumber, countStars, countOfBeds, price));
    }

    public void runAddNewOrder(Scanner scanner) {
        Integer id = reader.getInputInt(scanner, MenuConstEnum.ID_THE_ORDER.getDescription());
        Integer orderNumber = reader.getInputInt(scanner, "Enter the number of the order.");
        Date dateOfArrival = reader.getInputDate(scanner, "Enter the date of arrival (format dd/MM/yyyy).");
        Date dateOfDeparture = reader.getInputDate(scanner, "Enter the date of departure (format dd/MM/yyyy).");

        hotel.addOrder(new Order(id, orderNumber, dateOfArrival, dateOfDeparture));

    }

    public void runAddNewService(Scanner scanner) {
        Integer id = reader.getInputInt(scanner, MenuConstEnum.ID_THE_SERVICE.getDescription());
        String nameService = reader.getInputString(scanner, "Enter the name of the service.");
        Float price = reader.getInputFloat(scanner, "Enter the price of the service.");

        hotel.addUsedService(new UsedService(id, nameService, price));
    }

    public void runGetAllGuest() {
        hotel.getAllGuest();
    }

    public void runGetAllFreeRooms() {
        hotel.getFreeRooms();
    }

    public void runGetAllRoomsSortedByPrice() {
        hotel.sortedRoomsByPrice();
    }

    public void runGetAllRoomsSortedByCapacity() {
        hotel.sortedRoomsByCountBegs();
    }

    public void runGetAllRoomsSortedByCountOfStars() {
        hotel.sortedRoomsByCategory();
    }

    public void runGetAllFreeRoomsSortedByPrice() {
        hotel.sortedFreeRoomsByPrice();
    }

    public void runGetAllFreeRoomsSortedByCapacity() {
        hotel.sortedFreeRoomsByCountBegs();
    }

    public void runGetAllFreeRoomsSortedByCountOfStars() {
        hotel.sortedFreeRoomsByCategory();
    }

    public void runShowTotalPriceOfTheRoom(Scanner scanner) {
        Integer id = reader.getInputInt(scanner, "Enter id the room the cost which you need to know.");

        hotel.getRoomTotalPrice(hotel.getRoomById(id));
    }

    public void runAddRoomFromAGuest(Scanner scanner) {
        Integer idGuest = reader.getInputInt(scanner, MenuConstEnum.ID_THE_GUEST.getDescription());
        Integer idRoom = reader.getInputInt(scanner, MenuConstEnum.ID_THE_ROOM.getDescription());

        hotel.getGuestById(idGuest).setRoom(hotel.getRoomById(idRoom));
        hotel.getRoomById(idRoom).addGuest(hotel.getGuestById(idGuest));
    }

    public void runAddOrderFromAGuest(Scanner scanner) {
        Integer idGuest = reader.getInputInt(scanner, MenuConstEnum.ID_THE_GUEST.getDescription());
        Integer idOrder = reader.getInputInt(scanner, MenuConstEnum.ID_THE_ORDER.getDescription());

        hotel.getGuestById(idGuest).setOrder(hotel.getOrderById(idOrder));
    }

    public void runAddServiceFromARoom(Scanner scanner) {
        Integer idService = reader.getInputInt(scanner, MenuConstEnum.ID_THE_SERVICE.getDescription());
        Integer idRoom = reader.getInputInt(scanner, MenuConstEnum.ID_THE_ROOM.getDescription());

        hotel.getRoomById(idRoom).addService(hotel.getServiceById(idService));
    }

}
