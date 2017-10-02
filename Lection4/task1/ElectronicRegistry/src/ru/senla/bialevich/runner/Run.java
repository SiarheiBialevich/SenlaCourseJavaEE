package ru.senla.bialevich.runner;

import com.danco.training.TextFileWorker;
import ru.senla.bialevich.api.service.GuestService;
import ru.senla.bialevich.api.service.OrderService;
import ru.senla.bialevich.api.service.RoomService;
import ru.senla.bialevich.api.service.UsedServiceService;
import ru.senla.bialevich.entity.Guest;
import ru.senla.bialevich.entity.Order;
import ru.senla.bialevich.entity.Room;
import ru.senla.bialevich.entity.UsedService;
import ru.senla.bialevich.service.GuestServiceImpl;
import ru.senla.bialevich.service.OrderServiceImpl;
import ru.senla.bialevich.service.RoomServiceImpl;
import ru.senla.bialevich.service.UsedServiceServiceImpl;
import ru.senla.bialevich.util.DateUtil;
import ru.senla.bialevich.util.Printer;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Run {

    public static void main(String[] args) throws Exception {
        GuestService guestService = new GuestServiceImpl();
        RoomService roomService = new RoomServiceImpl();
        UsedServiceService usedService = new UsedServiceServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        DateUtil dateUtil = new DateUtil();

        Printer printer = new Printer();

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

        usedService.add(usedService1);
        usedService.add(usedService2);

        room1.addService(usedService1);

        room2.addService(usedService1);
        room2.addService(usedService2);

        guest1.setOrder(order1);
        guest2.setOrder(order2);
        guest3.setOrder(order2);

        guest1.setRoom(room1);
        guest2.setRoom(room2);
        guest3.setRoom(room2);

        guestService.add(guest1);
        guestService.add(guest2);
        guestService.add(guest3);

        roomService.add(room1);
        roomService.add(room2);
        roomService.add(room3);

        orderService.add(order1);
        orderService.add(order2);


        guestService.getAll();

        printer.printMessage("");

        System.out.println(roomService.getFreeRooms());

        printer.printMessage("");

        roomService.sortedRoomByPrice();

        printer.printMessage("");

        roomService.getAll();

        printer.printMessage("");

        roomService.sortedFreeRoomsByPrice();

        System.out.println();
        System.out.println();

        roomService.getTotalPrice(room1);

        printer.printMessage("");

        guestService.getTotalNumberOfGuests();

        printer.printMessage("");

        guestService.getServiceByGuest(guest1);

        printer.printMessage("");

        usedService.sortUsedServiceByPrice();

        printer.printMessage("");

        String[] arrayGuests = new String[guestService.getListGuests().size()];
        for (int i = 0; i < guestService.getListGuests().size(); i++) {
            arrayGuests[i] = String.valueOf(guestService.getListGuests().get(i));
        }

        final String TEST_FILE = args[0];
        final String[] testValues = arrayGuests;

        // Create new file
        Path filePath = Paths.get(TEST_FILE);
        Files.createFile(filePath);

        // Work example
        try{
            TextFileWorker fileWorker = new TextFileWorker(TEST_FILE);
            fileWorker.writeToFile(testValues);
            Object[] readedValues = fileWorker.readFromFile();

            // Check result
            for (int i = 0; i < testValues.length; i++ ){

                if ( ! readedValues[i].equals(testValues[i])){
                    throw new RuntimeException("Error. Not equal values: " + readedValues[i] + " and " + testValues[i]);
                }
            }

            for (Object object : readedValues) {
                printer.printObject(object);
            }
        }finally{
//            Files.deleteIfExists(filePath);
        }
    }
}
