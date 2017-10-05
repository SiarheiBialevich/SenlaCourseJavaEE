package ru.senla.bialevich.service;

import ru.senla.bialevich.api.dao.RoomDao;
import ru.senla.bialevich.api.service.RoomService;
import ru.senla.bialevich.dao.RoomDaoImpl;
import ru.senla.bialevich.entity.Room;
import ru.senla.bialevich.util.CopyAndSortList;
import ru.senla.bialevich.util.Printer;
import ru.senla.bialevich.util.comparator.roomComparator.RoomCategoryComparator;
import ru.senla.bialevich.util.comparator.roomComparator.RoomCountBegsComparator;
import ru.senla.bialevich.util.comparator.roomComparator.RoomPriceComparator;

import java.util.ArrayList;
import java.util.List;

public class RoomServiceImpl implements RoomService {
    private static final RoomPriceComparator PRICE_COMPARATOR = new RoomPriceComparator();
    private static final RoomCountBegsComparator COUNT_BEGS_COMPARATOR = new RoomCountBegsComparator();
    private static final RoomCategoryComparator CATEGORY_COMPARATOR = new RoomCategoryComparator();

    private Printer printer = new Printer();
    private CopyAndSortList<Room> copy = new CopyAndSortList<Room>();

    private static final String MESSAGE1 = "Sorted rooms by price";
    private static final String MESSAGE2 = "Sorted rooms by count begs";
    private static final String MESSAGE3 = "Sorted rooms by category";
    private static final String MESSAGE4 = "Sorted free rooms by price";
    private static final String MESSAGE5 = "Sorted free rooms by count begs";
    private static final String MESSAGE6 = "Sorted free rooms by category";
    private static final String MESSAGE7 = "Get free rooms";
    private static final String MESSAGE8 = "Total free rooms";
    private static final String MESSAGE9 = "All rooms";
    private static final String MESSAGE10 = "Total price room ";

    private RoomDao roomDao = new RoomDaoImpl();


    public void add(Room room) {
        roomDao.add(room);
    }

    @Override
    public List<Room> getFreeRooms() {
        printer.print(MESSAGE7);
        List<Room> rooms = new ArrayList<>();
        for (int i = 0; i < roomDao.getAll().size(); i++) {
            if (roomDao.getAll().get(i).isFree()) {
                rooms.add(roomDao.getAll().get(i));
            }
        }

        return rooms;
    }

    @Override
    public void sortedRoomsByPrice() {
        printer.print(MESSAGE1);
        printer.print(copy.getCopiedAndSortedList(roomDao.getAll(), PRICE_COMPARATOR));
    }

    @Override
    public void sortedRoomsByCountBegs() {
        printer.print(MESSAGE2);
        printer.print(copy.getCopiedAndSortedList(roomDao.getAll(), COUNT_BEGS_COMPARATOR));
    }

    @Override
    public void sortedRoomsByCategory() {
        printer.print(MESSAGE3);
        printer.print(copy.getCopiedAndSortedList(roomDao.getAll(), CATEGORY_COMPARATOR));
    }

    @Override
    public void sortedFreeRoomsByPrice() {
        printer.print(MESSAGE4);
        printer.print(copy.getCopiedAndSortedList(getFreeRooms(), PRICE_COMPARATOR));
    }

    @Override
    public void sortedFreeRoomsByCountBegs() {
        printer.print(MESSAGE5);
        printer.print(copy.getCopiedAndSortedList(getFreeRooms(), COUNT_BEGS_COMPARATOR));
    }

    @Override
    public void sortedFreeRoomsByCategory() {
        printer.print(MESSAGE6);
        printer.print(copy.getCopiedAndSortedList(getFreeRooms(), CATEGORY_COMPARATOR));
    }

    @Override
    public void getTotalFreeNumberOfRooms() {
        printer.print(MESSAGE8);
        printer.print(getFreeRooms().size());
    }

    @Override
    public void getTotalPrice(Room room) {
        printer.print(MESSAGE10, room.getRoomNumber(), room.getPrice());
    }

    @Override
    public void getAll() {
        printer.print(MESSAGE9);

        for (int i = 0; i < roomDao.getAll().size(); i++) {
            printer.print(roomDao.getAll().get(i));
        }

    }

    @Override
    public List<Room> getListRooms() {
        return roomDao.getAll();
    }
}
