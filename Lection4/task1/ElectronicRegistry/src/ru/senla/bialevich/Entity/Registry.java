package ru.senla.bialevich.Entity;

import ru.senla.bialevich.util.Printer;
import ru.senla.bialevich.util.comparator.guestComparator.GuestDateOfDepartureComparator;
import ru.senla.bialevich.util.comparator.guestComparator.GuestSurnameComparator;
import ru.senla.bialevich.util.comparator.roomComparator.RoomCountBegsComparator;
import ru.senla.bialevich.util.comparator.roomComparator.RoomPriceComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Registry {
    private Printer print = new Printer();

    private List<Room> rooms = new ArrayList<Room>();
    private List<Room> freeRooms = new ArrayList<Room>();
    private List<Guest> guests = new ArrayList<Guest>();
    private List<Order> orders = new ArrayList<Order>();

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void addGuest(Guest guest) {
        guests.add(guest);
    }

    public void deleteGuest(Guest guest) {
        guests.remove(guest);
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public void deleteOrder(Order order) {
        orders.remove(order);
    }

    public List<Room> getFreeRoom() {
        for (Room room : rooms) {
            if (room.isFree()) {
                freeRooms.add(room);
            }
        }

        return freeRooms;
    }

    public void sortedRoomsByPrice() {
        String SORTED_BY_PRICE = "Sorted room by price";

        Collections.sort(rooms, new RoomPriceComparator());
        print.printMessage(SORTED_BY_PRICE);

        for (Room room : rooms) {
            print.printMessage(room.toString());
        }
    }

    public void sortedRoomsByCountBegs() {
        String SORTED_BY_BEGS = "Sorted room by count begs";

        Collections.sort(rooms, new RoomCountBegsComparator());
        print.printMessage(SORTED_BY_BEGS);

        for (Room room : rooms) {
            print.printMessage(room.toString());
        }
    }

    public void sortedRoomsByCountStars() {
        String SORTED_BY_STARS = "Sorted room by count stars";

        Collections.sort(rooms, new RoomCountBegsComparator());
        print.printMessage(SORTED_BY_STARS);

        for (Room room : rooms) {
            print.printMessage(room.toString());
        }
    }

    public void sortedGuestBySurname() {
        String SORTED_BY_SURNAME = "Sorted guest by surname";

        Collections.sort(guests, new GuestSurnameComparator());
        print.printMessage(SORTED_BY_SURNAME);

        for (Guest guect : guests) {
            print.printMessage(guect.toString());
        }
    }

    public void sortedGuestByDateOfDeparture() {
        String SORTED_BY_SURNAME = "Sorted guest by date of departure";

        Collections.sort(guests, new GuestDateOfDepartureComparator());
        print.printMessage(SORTED_BY_SURNAME);

        for (Guest guect : guests) {
            print.printMessage(guect.toString());
        }
    }

}
