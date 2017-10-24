package ru.senla.bialevich.util.importer;

import org.apache.log4j.Logger;
import ru.senla.bialevich.api.dao.GuestDao;
import ru.senla.bialevich.api.dao.OrderDao;
import ru.senla.bialevich.api.dao.RoomDao;
import ru.senla.bialevich.controller.ControllerHotelImpl;
import ru.senla.bialevich.dao.GuestDaoImpl;
import ru.senla.bialevich.dao.OrderDaoImpl;
import ru.senla.bialevich.dao.RoomDaoImpl;
import ru.senla.bialevich.entity.Guest;
import ru.senla.bialevich.entity.Order;
import ru.senla.bialevich.entity.Room;
import ru.senla.bialevich.util.converter.Converter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Importer {
    private static final Logger LOG = Logger.getLogger(Importer.class);
    private static final String path = ControllerHotelImpl.getInstance().getProperty("path.to.entity.file");

    private Converter converter;

    private Map<Integer, Room> roomsMap;
    private Map<Integer, Order> ordersMap;

    public Importer(List<Order> orders, List<Room> rooms) {
        this.converter = new Converter();
        initMaps(orders, rooms);
    }

    public void importGuests(List<Guest> guests) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = "";
            while ((line = br.readLine()) != null) {
                if (isModel(line, Guest.ENTITY_TOKEN)) {
                    Guest guest = converter.convertStringToGuest(line, roomsMap, ordersMap);
                    if (guests.contains(guest)) {
                        guests.set(guest.getId(), guest);
                    } else {
                        guests.add(guest);
                    }
                }
            }
            GuestDao guestDao = new GuestDaoImpl(guests);
        } catch (IOException e) {
            LOG.error(e.getMessage());
        }
    }

    public void importRooms(List<Room> rooms) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = "";
            while ((line = br.readLine()) != null) {
                if (isModel(line, Room.ENTITY_TOKEN)) {
                    Room room = converter.convertStringToRoom(line);
                    if (room.getId() == ControllerHotelImpl.getInstance().getRoomById(room.getId()).getId()) {
                        ControllerHotelImpl.getInstance().updateRoom(room);
                    } else {
                        rooms.add(room);
                        roomsMap.put(room.getId(), room);
                    }
                }
            }
            RoomDao roomDao = new RoomDaoImpl(rooms);
        } catch (IOException e) {
            LOG.error(e.getMessage());
        }
    }

    public void importOrders(List<Order> orders) {

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = "";
            while ((line = br.readLine()) != null) {
                if (isModel(line, Order.ENTITY_TOKEN)) {
                    Order order = converter.convertStringToRegistration(line);
                    if (order.getId() == ControllerHotelImpl.getInstance().getOrderById(order.getId()).getId()) {
                        ControllerHotelImpl.getInstance().updateOrder(order);
                    } else {
                        orders.add(order);
                    }
                }
            }
            OrderDao orderDao = new OrderDaoImpl(orders);
        } catch (IOException e) {
            LOG.error(e.getMessage());
        }
    }

    private void initMaps(List<Order> orders, List<Room> rooms) {
        ordersMap = new HashMap<>();
        roomsMap = new HashMap<>();
        if (orders != null) {
            for (Order order : orders) {
                ordersMap.put(order.getId(), order);
            }
        }
        if (rooms != null) {
            for (Room room : rooms) {
                roomsMap.put(room.getId(), room);
            }
        }
    }

    private boolean isModel(String string, String token) {
        String[] values = string.split(";");
        return values[0].contains(token);
    }
}
