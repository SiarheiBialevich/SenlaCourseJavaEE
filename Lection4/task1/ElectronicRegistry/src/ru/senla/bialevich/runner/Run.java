package ru.senla.bialevich.runner;

import ru.senla.bialevich.api.controller.ControllerHotel;
import ru.senla.bialevich.controller.ControllerHotelImpl;
import ru.senla.bialevich.entity.Guest;
import ru.senla.bialevich.entity.Order;
import ru.senla.bialevich.entity.Room;
import ru.senla.bialevich.entity.UsedService;
import ru.senla.bialevich.util.DateUtil;
import ru.senla.bialevich.util.Printer;
import ru.senla.bialevich.util.writeAndRaed.WriteAndRead;

public class Run {

    public static void main(String[] args) throws Exception {
        ControllerHotel hotel = new ControllerHotelImpl();
        DateUtil dateUtil = new DateUtil();
        Printer printer = new Printer();

        WriteAndRead writeAndRead = new WriteAndRead("d:/test.txt");

        Guest guest1 = new Guest("Peter", "Ivanov");
        Guest guest2 = new Guest("Alex", "Born");
        Guest guest3 = new Guest("Elize", "Born");

        Room room1 = new Room(101, 3, 3, false, 150.0f);
        Room room2 = new Room(201, 4, 2, true, 180.0f);
        Room room3 = new Room(301, 4, 2, true, 100.0f);

        Order order1 = new Order(1, dateUtil.create("01/05/2017"), dateUtil.create("10/05/2017"));
        Order order2 = new Order(2, dateUtil.create("25/05/2017"), dateUtil.create("26/05/2017"));

        UsedService usedService1 = new UsedService("Cable TV", 1.5f);
        UsedService usedService2 = new UsedService("WI-FI", 2.5f);

        room1.addService(usedService1);
        room2.addService(usedService1);
        room2.addService(usedService2);

        guest1.setOrder(order1);
        guest2.setOrder(order2);
        guest3.setOrder(order2);

        guest1.setRoom(room1);
        guest2.setRoom(room2);
        guest3.setRoom(room2);

        hotel.addUsedService(usedService1);
        hotel.addUsedService(usedService2);

        hotel.addGuest(guest1);
        hotel.addGuest(guest2);
        hotel.addGuest(guest3);

        hotel.addRoom(room1);
        hotel.addRoom(room2);
        hotel.addRoom(room3);

        hotel.addOrder(order1);
        hotel.addOrder(order2);

        hotel.getAllGuest();

        printer.print("");

        hotel.getFreeRooms();

        printer.print("");

        hotel.sortedRoomsByPrice();

        printer.print("");

        hotel.getAllRooms();

        printer.print("");

        hotel.sortedFreeRoomsByPrice();

        printer.print("");

        hotel.getRoomTotalPrice(room1);

        printer.print("");

        hotel.getTotalNumberOfGuests();

        printer.print("");

        hotel.getServiceByGuest(guest1);

        printer.print("");

        hotel.sortUsedServicesByPrice();

        printer.print("");

        writeAndRead.writeToFile(hotel.getListGuests());

        writeAndRead.readFromFile();
    }
}
