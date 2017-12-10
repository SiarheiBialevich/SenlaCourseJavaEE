package ru.senla.bialevich.util.initializer;

import org.apache.log4j.Logger;
import ru.senla.bialevich.ClassSetting;
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
import ru.senla.bialevich.service.GuestServiceImpl;
import ru.senla.bialevich.service.OrderServiceImpl;
import ru.senla.bialevich.service.RoomServiceImpl;
import ru.senla.bialevich.service.UsedServiceServiceImpl;
import ru.senla.bialevich.util.converter.Converter;
import ru.senla.bialevich.util.serialization.WriteModel;
import ru.senla.bialevich.util.wrapper.Wrapper;

public class Initializer {
    private static final Logger LOG = Logger.getLogger(Initializer.class);
    private static final String PATH = ClassSetting.getInstance().getProperty("main.file");

    private GuestService guestService = new GuestServiceImpl();
    private RoomService roomService = new RoomServiceImpl();
    private OrderService orderService = new OrderServiceImpl();
    private UsedServiceService usedServiceService = new UsedServiceServiceImpl();

    private Converter converter;
    private WriteModel writeModel;

    public Initializer() {
        this.writeModel = new WriteModel();
        this.converter = new Converter();
        this.fillDataObjects();
        this.fillServices();
    }

    private void fillServices() {
        GuestDao guestDao = new GuestDaoImpl();
        RoomDao roomDao = new RoomDaoImpl();
        OrderDao orderDao = new OrderDaoImpl();
        UsedServiceDao serviceDao = new UsedServiceDaoImpl();
        guestService = new GuestServiceImpl(guestDao, orderDao);
        roomService = new RoomServiceImpl(roomDao, guestDao, orderDao);
        orderService = new OrderServiceImpl(orderDao);
        usedServiceService = new UsedServiceServiceImpl(serviceDao);
    }

    private void fillDataObjects() {

        Wrapper wrapper = (Wrapper) writeModel.loadModel(PATH);

        if (wrapper != null) {
            convertWrapperToModel(wrapper);
        }
    }

    private void convertWrapperToModel(Wrapper wrapper) {
        guestService.setGuestList(wrapper.getGuests());
        roomService.setRoomList(wrapper.getRooms());
        usedServiceService.setServicesList(wrapper.getServices());
        orderService.setOrdersList(wrapper.getOrders());
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
