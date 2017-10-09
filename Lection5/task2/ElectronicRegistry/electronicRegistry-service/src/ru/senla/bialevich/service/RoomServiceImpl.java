package ru.senla.bialevich.service;

import ru.senla.bialevich.api.dao.RoomDao;
import ru.senla.bialevich.api.service.RoomService;
import ru.senla.bialevich.dao.RoomDaoImpl;
import ru.senla.bialevich.entity.Room;
import ru.senla.bialevich.enums.ServiceConstEnum;
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

    private RoomDao roomDao = new RoomDaoImpl();


    public void add(Room room) {
        roomDao.add(room);
    }

    @Override
    public Room getRoomById(Integer id) {
        return roomDao.getRoomById(id);
    }

    @Override
    public List<Room> getFreeRooms() {
        printer.print(ServiceConstEnum.GET_FREE_ROOMS.getDescription());
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
        printer.print(ServiceConstEnum.SORTED_ROOMS_BY_PRICE.getDescription());
        printer.print(copy.getCopiedAndSortedList(roomDao.getAll(), PRICE_COMPARATOR));
    }

    @Override
    public void sortedRoomsByCountBegs() {
        printer.print(ServiceConstEnum.SORTED_ROOMS_BY_COUNT_BEGS.getDescription());
        printer.print(copy.getCopiedAndSortedList(roomDao.getAll(), COUNT_BEGS_COMPARATOR));
    }

    @Override
    public void sortedRoomsByCategory() {
        printer.print(ServiceConstEnum.SORTED_ROOMS_BY_CATEGORY.getDescription());
        printer.print(copy.getCopiedAndSortedList(roomDao.getAll(), CATEGORY_COMPARATOR));
    }

    @Override
    public void sortedFreeRoomsByPrice() {
        printer.print(ServiceConstEnum.SORTED_FREE_ROOMS_BY_PRICE.getDescription());
        printer.print(copy.getCopiedAndSortedList(getFreeRooms(), PRICE_COMPARATOR));
    }

    @Override
    public void sortedFreeRoomsByCountBegs() {
        printer.print(ServiceConstEnum.SORTED_FREE_ROOMS_BY_COUNT_BEGS.getDescription());
        printer.print(copy.getCopiedAndSortedList(getFreeRooms(), COUNT_BEGS_COMPARATOR));
    }

    @Override
    public void sortedFreeRoomsByCategory() {
        printer.print(ServiceConstEnum.SORTED_FREE_ROOMS_BY_COUNT_CATEGORY.getDescription());
        printer.print(copy.getCopiedAndSortedList(getFreeRooms(), CATEGORY_COMPARATOR));
    }

    @Override
    public void getTotalFreeNumberOfRooms() {
        printer.print(ServiceConstEnum.GET_TOTAL_FREE_ROOMS.getDescription());
        printer.print(getFreeRooms().size());
    }

    @Override
    public void getTotalPrice(Room room) {
        printer.print(ServiceConstEnum.GET_TOTAL_PRICE_ROOMS.getDescription(), room.getRoomNumber(), room.getPrice());
    }

    @Override
    public void getAll() {
        printer.print(ServiceConstEnum.GET_ALL_ROOMS.getDescription());

        for (int i = 0; i < roomDao.getAll().size(); i++) {
            printer.print(roomDao.getAll().get(i));
        }

    }

    @Override
    public List<Room> getListRooms() {
        return roomDao.getAll();
    }
}
