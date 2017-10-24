package ru.senla.bialevich.util.initializer;

import org.apache.log4j.Logger;
import ru.senla.bialevich.api.dao.GuestDao;
import ru.senla.bialevich.api.dao.OrderDao;
import ru.senla.bialevich.api.dao.RoomDao;
import ru.senla.bialevich.api.dao.UsedServiceDao;
import ru.senla.bialevich.api.service.GuestService;
import ru.senla.bialevich.api.service.OrderService;
import ru.senla.bialevich.api.service.RoomService;
import ru.senla.bialevich.api.service.UsedServiceService;
import ru.senla.bialevich.dao.GuestDaoImpl;
import ru.senla.bialevich.dao.OrderDaoImpl;
import ru.senla.bialevich.dao.RoomDaoImpl;
import ru.senla.bialevich.dao.UsedServiceDaoImpl;
import ru.senla.bialevich.entity.Guest;
import ru.senla.bialevich.entity.Order;
import ru.senla.bialevich.entity.Room;
import ru.senla.bialevich.entity.UsedService;
import ru.senla.bialevich.service.GuestServiceImpl;
import ru.senla.bialevich.service.OrderServiceImpl;
import ru.senla.bialevich.service.RoomServiceImpl;
import ru.senla.bialevich.service.UsedServiceServiceImpl;
import ru.senla.bialevich.util.converter.Converter;
import ru.senla.bialevich.util.service.WriteModel;

import java.util.ArrayList;
import java.util.List;

public class Initializer {
    private static final Logger LOG = Logger.getLogger(Initializer.class);

    private GuestService guestService;
    private RoomService roomService;
    private OrderService orderService;
    private UsedServiceService usedServiceService;

    private List<Guest> guests = new ArrayList<>();
    private List<Room> rooms = new ArrayList<>();
    private List<Order> orders = new ArrayList<>();
    private List<UsedService> services = new ArrayList<>();

    private Converter converter;
    private WriteModel writeModel;

    public Initializer() {
        this.writeModel = new WriteModel();
        this.converter = new Converter();
        this.fillDataObjects();
        this.fillServices();
    }

    private void fillServices() {
        GuestDao guestDao = new GuestDaoImpl(this.guests);
        RoomDao roomDao = new RoomDaoImpl(this.rooms);
        OrderDao orderDao = new OrderDaoImpl(this.orders);
        UsedServiceDao serviceDao = new UsedServiceDaoImpl(this.services);
        guestService = new GuestServiceImpl(guestDao, orderDao);
        roomService = new RoomServiceImpl(roomDao, guestDao, orderDao);
        orderService = new OrderServiceImpl(orderDao);
        usedServiceService = new UsedServiceServiceImpl(serviceDao);
    }

    private void fillDataObjects() {
        List<Object> data = writeModel.loadModel();
        convertDataToModel(data);
    }

    private void convertDataToModel(List<Object> data) {
        try {
            this.guests = (List<Guest>) data.get(0);
            this.rooms = (List<Room>) data.get(1);
            this.services = (List<UsedService>) data.get(2);
            this.orders = (List<Order>) data.get(3);
        }catch (Exception e) {
            LOG.error(e.getMessage());
        }
    }

    public GuestService getGuestService() {
        return this.guestService;
    }

    public RoomService getRoomService() {
        return this.roomService;
    }

    public OrderService getOrderService() {
        return this.orderService;
    }

    public UsedServiceService getServiceService() {
        return this.usedServiceService;
    }
}
