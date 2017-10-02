package ru.senla.bialevich.service;

import ru.senla.bialevich.api.dao.RoomDao;
import ru.senla.bialevich.api.service.RoomService;
import ru.senla.bialevich.dao.RoomDaoImpl;
import ru.senla.bialevich.entity.Room;
import ru.senla.bialevich.util.Printer;
import ru.senla.bialevich.util.comparator.roomComparator.RoomCategoryComparator;
import ru.senla.bialevich.util.comparator.roomComparator.RoomCountBegsComparator;
import ru.senla.bialevich.util.comparator.roomComparator.RoomPriceComparator;

import java.util.ArrayList;
import java.util.List;

public class RoomServiceImpl implements RoomService {

    private RoomPriceComparator priceComparator = new RoomPriceComparator();
    private RoomCountBegsComparator countBegsComparator = new RoomCountBegsComparator();
    private RoomCategoryComparator categoryComparator = new RoomCategoryComparator();

    private Printer printer = new Printer();

    private final String MESSAGE1 = "Sorted rooms by price";
    private final String MESSAGE2 = "Sorted rooms by count begs";
    private final String MESSAGE3 = "Sorted rooms by category";
    private final String MESSAGE4 = "Sorted free rooms by price";
    private final String MESSAGE5 = "Sorted free rooms by count begs";
    private final String MESSAGE6 = "Sorted free rooms by category";
    private final String MESSAGE7 = "Get free rooms";
    private final String MESSAGE8 = "Total free rooms";
    private final String MESSAGE9 = "All rooms";
    private final String MESSAGE10 = "Total price room ";

    private RoomDao roomDao = new RoomDaoImpl();

    public void add(Room room) {
        roomDao.add(room);
    }

    @Override
    public List<Room> getFreeRooms() {
        printer.printMessage(MESSAGE7);
        List<Room> rooms = new ArrayList<>();
        for (int i = 0; i <roomDao.getAll().size(); i++) {
            if (roomDao.getAll().get(i).isFree()) {
                rooms.add(roomDao.getAll().get(i));
            }
        }

        return rooms;
    }

    @Override
    public void sortedRoomByPrice() {
        printer.printMessage(MESSAGE1);

        ArrayList<Room> roomsSorted = new ArrayList<Room>(roomDao.getAll());
        roomsSorted.sort(priceComparator);
        for (Room room : roomsSorted) {
            printer.printObject(room);
        }
    }

    @Override
    public void sortedRoomByCountBegs() {
        printer.printMessage(MESSAGE2);

        ArrayList<Room> roomsSorted = new ArrayList<Room>(roomDao.getAll());
        roomsSorted.sort(countBegsComparator);

        for (Room room : roomsSorted) {
            printer.printObject(room);
        }

    }

    @Override
    public void sortedRoomByCategory() {
        printer.printMessage(MESSAGE3);

        ArrayList<Room> roomsSorted = new ArrayList<Room>(roomDao.getAll());
        roomsSorted.sort(categoryComparator);

        for (Room room : roomsSorted) {
            printer.printObject(room);
        }
    }

    @Override
    public void sortedFreeRoomsByPrice() {
        printer.printMessage(MESSAGE4);

        ArrayList<Room> roomsSorted = new ArrayList<Room>(getFreeRooms());
        roomsSorted.sort(priceComparator);
        for (Room room : roomsSorted) {
            printer.printObject(room);
        }
    }

    @Override
    public void sortedFreeRoomsByCountBegs() {
        printer.printMessage(MESSAGE5);

        ArrayList<Room> roomsSorted = new ArrayList<Room>(getFreeRooms());
        roomsSorted.sort(countBegsComparator);

        for (Room room : roomsSorted) {
            printer.printObject(room);
        }

    }

    @Override
    public void sortedRoomsByCategory() {
        printer.printMessage(MESSAGE6);

        ArrayList<Room> roomsSorted = new ArrayList<Room>(getFreeRooms());
        roomsSorted.sort(categoryComparator);

        for (Room room : roomsSorted) {
            printer.printObject(room);
        }
    }

    @Override
    public void getTotalFreeNumberOfRooms() {
        printer.printMessage(MESSAGE8);
        printer.printObject(getFreeRooms().size());
    }

    @Override
    public void getTotalPrice(Room room) {
        printer.printInfo(MESSAGE10, room.getRoomNumber(), room.getPrice());
    }

    @Override
    public void getAll() {
        printer.printMessage(MESSAGE9);

        for (int i = 0; i < roomDao.getAll().size(); i++) {
            printer.printObject(roomDao.getAll().get(i));
        }

    }

    @Override
    public List<Room> getListRooms() {
        return roomDao.getAll();
    }
}
