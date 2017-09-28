package ru.senla.bialevich.worker;

import ru.senla.bialevich.entity.*;
import ru.senla.bialevich.util.Printer;
import ru.senla.bialevich.writeAndRead.ReadObjectFromFile;
import ru.senla.bialevich.writeAndRead.WriteObjectToFile;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RegistryWorker {
    public void start() throws ParseException {
        WriteObjectToFile writeObject = new WriteObjectToFile();
        ReadObjectFromFile readObject = new ReadObjectFromFile();

        final String FREE_ROOMS = "Free rooms";
        final String TOTAL_PRICE = "Total price room number ";
        final String DIRECTORY = "d:\\-= JAVA =-\\SenlaCoursJavaEE\\Lection4\\task1\\ElectronicRegistry\\" +
                "src\\ru\\senla\\bialevich\\text\\";

        final String FILENAME = "guest.ser";
        final String FILENAME1 = "room.ser";

        Registry registry = new Registry();
        Printer print = new Printer();

        Room room1 = new Room(101, 3, 3, true, 150.0f);
        Room room2 = new Room(201, 4, 2, false, 180.0f);
        Room room3 = new Room(301, 5, 1, false, 280.0f);

        Guest guest1 = new Guest("Peter", "Ivanov");
        Guest guest2 = new Guest("Alex", "Born");
        Guest guest3 = new Guest("Elize", "Born");

        Service service1 = new Service("Cable TV", 1.5f);
        Service service2 = new Service("WI-FI", 2.5f);

        room2.addService(service1);

        room3.addService(service1);
        room3.addService(service2);

        DateFormat dFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date1 = dFormat.parse("01-05-2017");
        Date date2 = dFormat.parse("10-05-2017");

        Date date3 = dFormat.parse("25-05-2017");
        Date date4 = dFormat.parse("25-06-2017");

        Order order1 = new Order(1, date1, date2);
        Order order2 = new Order(2, date3, date4);

        guest1.setOrder(order1);
        guest2.setOrder(order2);
        guest3.setOrder(order2);

        guest1.setRoom(room2);
        guest2.setRoom(room3);
        guest3.setRoom(room3);

        registry.addRoom(room1);
        registry.addRoom(room2);
        registry.addRoom(room3);
        print.printMessageAndObject(FREE_ROOMS, registry.getFreeRoom());

        registry.sortedRoomsByPrice();
        registry.sortedRoomsByCountStars();
        registry.sortedRoomsByCountBegs();

        registry.addGuest(guest1);
        registry.addGuest(guest2);
        registry.addGuest(guest3);
        registry.sortedGuestBySurname();
        registry.sortedGuestByDateOfDeparture();

        print.printInfo(TOTAL_PRICE, room1.getRoomNumber(), room1.getPrice());
        print.printInfo(TOTAL_PRICE, room2.getRoomNumber(), room2.getPrice());
        print.printInfo(TOTAL_PRICE, room3.getRoomNumber(), room3.getPrice());

        writeObject.writeToFile(DIRECTORY, FILENAME, registry.getGuests());
        writeObject.writeToFile(DIRECTORY, FILENAME1, registry.getRooms());

        readObject.readFromFile(DIRECTORY+FILENAME, registry.getGuests());
        readObject.readFromFile(DIRECTORY+FILENAME1, registry.getRooms());
    }
}
