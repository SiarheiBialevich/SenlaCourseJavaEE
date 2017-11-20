package ru.senla.bialevich.controller;

import ru.senla.bialevich.ClassSetting;
import ru.senla.bialevich.annotations.AnnotationWorker;
import ru.senla.bialevich.annotations.ConfigProperty;

import ru.senla.bialevich.dependency.DependencyInjection;
import ru.senla.bialevich.entity.Guest;
import ru.senla.bialevich.entity.Order;
import ru.senla.bialevich.entity.Room;
import ru.senla.bialevich.entity.UsedService;
import ru.senla.bialevich.util.exporter.Exporter;
import ru.senla.bialevich.util.importer.Importer;
import ru.senla.bialevich.util.serialization.WriteModel;
import ru.senla.bialevich.util.serialization.WriteObject;
import ru.senla.bialevich.util.wrapper.Wrapper;
import ru.senla.bialevich.service.GuestService;
import ru.senla.bialevich.service.OrderService;
import ru.senla.bialevich.service.RoomService;
import ru.senla.bialevich.service.UsedServiceService;

import java.util.List;

public class ControllerHotelImpl implements ControllerHotel {

    private static final String PATH = ClassSetting.getInstance().getProperty("main.file");

    @ConfigProperty(configName = "props\\resources\\annotation.properties", propertyName = "block.status", type = Boolean.class)
    private boolean isProps;

    private WriteModel writeModel = new WriteModel();

    private Importer importer;
    private Exporter exporter;

    private WriteObject writeObject;
    private ClassSetting setting;

    private GuestService guestService;
    private OrderService orderService;
    private RoomService roomService;
    private UsedServiceService usedService;


    private static ControllerHotel hotel;


    public static ControllerHotel getInstance() {
        if (hotel == null) {
            hotel = new ControllerHotelImpl();
        }

        return hotel;
    }

    public ControllerHotelImpl() {
    }

    @Override
    public void init() {
        this.setting = new ClassSetting();
        this.writeObject = new WriteObject();
        this.fillServicesFromInitializer();
        this.importer = new Importer();
        this.exporter = new Exporter(writeObject);
        fillDataObjects();
        AnnotationWorker.getInstance().configure(this);
    }

    @Override
    public String getProperty(String key) {

        return setting.getProperty(key);
    }

    private void fillServicesFromInitializer() {
        this.guestService = (GuestService) DependencyInjection.getInjection().getInstance(GuestService.class);
        this.roomService = (RoomService) DependencyInjection.getInjection().getInstance(RoomService.class);
        this.orderService = (OrderService) DependencyInjection.getInjection().getInstance(OrderService.class);
        this.usedService = (UsedServiceService) DependencyInjection.getInjection().getInstance(UsedServiceService.class);
    }

    //Guests
    @Override
    public void addGuest(Guest guest) {
        synchronized (guestService) {
            guestService.add(guest);
        }
    }

    @Override
    public Guest getGuestById(Integer id) {
        return guestService.getGuestById(id);
    }

    @Override
    public List<Guest> getAllGuest() {
        return guestService.getAll();
    }

    @Override
    public void updateGuest(Guest guest) {
        guestService.update(guest);
    }

    @Override
    public Integer getTotalNumberOfGuests() {
        return guestService.getTotalNumberOfGuests();
    }

    @Override
    public List<Guest> sortedGuestsBySurname() {
        return guestService.sortedGuestsBySurname();
    }

    @Override
    public List<Guest> sortedGuestsByDateOfDeparture() {
        return guestService.sortedGuestsByDateOfDeparture();
    }

    @Override
    public List<Guest> getListGuests() {
        return guestService.getListGuests();
    }

    @Override
    public void setOrderToGuest(Guest guest, Order order) {
        guestService.setOrderToGuest(guest, order);
    }

    public void setRoomToGuest(Guest guest, Room room) {
        guestService.setRoomToGuest(guest, room);
    }

    public void importGuests() {
        synchronized (guestService) {
            Integer id = 1;

            List<Guest> guests = importer.importGuests();

            for (Guest guest : guests) {
                if (hotel.getGuestById(id) != null) {
                    if (hotel.getGuestById(id).getId().equals(guest.getId())) {
                        hotel.updateGuest(guest);
                    }
                } else {
                    hotel.addGuest(guest);
                }
                id++;
            }
        }
    }

    @Override
    public void exportGuests() {
        synchronized (guestService) {
            exporter.exportGuests(guestService.getAll());
        }
    }


    //Rooms
    @Override
    public void addRoom(Room room) {
        roomService.add(room);
    }

    @Override
    public Room getRoomById(Integer id) {
        return roomService.getRoomById(id);
    }

    @Override
    public List<Room> getFreeRooms() {
        return roomService.getFreeRooms();
    }

    @Override
    public List<Room> getTotalFreeNumberOfRooms() {
        return roomService.getFreeRooms();
    }

    @Override
    public Float getRoomTotalPrice(Room room) {
        return roomService.getTotalPrice(room);
    }

    @Override
    public List<Room> getAllRooms() {
        return roomService.getAll();
    }

    @Override
    public List<Room> getListRooms() {
        return roomService.getListRooms();
    }

    @Override
    public void registerGuestInRoom(Guest guest, Room room) {
        roomService.registerGuestInRoom(guest, room);
    }

    @Override
    public boolean changeRoomStatus(Room room) {
        if (isProps) {
            room.setFree(false);
            roomService.update(room);
            return true;
        }
        return false;
    }

    @Override
    public void changeRoomPrice(Room room, Float value) {
        room.setPrice(value);
        roomService.update(room);
    }

    @Override
    public void updateRoom(Room room) {
        roomService.update(room);
    }

    public Room cloneRoom(Integer id) {
        return roomService.cloneRoom(id);
    }

    @Override
    public List<Room> sortedRoomsByPrice() {
        return roomService.sortedRoomsByPrice();
    }

    @Override
    public List<Room> sortedRoomsByCountBegs() {
        return roomService.sortedRoomsByCountBegs();
    }

    @Override
    public List<Room> sortedRoomsByCategory() {
        return roomService.sortedRoomsByCategory();
    }

    @Override
    public List<Room> sortedFreeRoomsByPrice() {
        return roomService.sortedFreeRoomsByPrice();
    }

    @Override
    public List<Room> sortedFreeRoomsByCountBegs() {
        return roomService.sortedFreeRoomsByCountBegs();
    }

    @Override
    public List<Room> sortedFreeRoomsByCategory() {
        return roomService.sortedFreeRoomsByCategory();
    }

    @Override
    public void setServiceToRoom(Room room, UsedService service) {
        roomService.setServiceToRoom(room, service);
    }

    @Override
    public void importRooms() {
        synchronized (roomService) {
            List<Room> rooms = importer.importRooms();

            Integer id = 1;

            for (Room room : rooms) {
                if (hotel.getRoomById(id) != null) {
                    if (hotel.getRoomById(id).getId().equals(room.getId())) {
                        hotel.updateRoom(room);
                    }
                } else {
                    hotel.addRoom(room);
                }
                id++;
            }
        }
    }

    @Override
    public void exportRooms() {
        synchronized (roomService) {
            exporter.exportRooms(this.roomService.getAll());
        }
    }

    //Orders
    @Override
    public void addOrder(Order order) {
        orderService.add(order);
    }

    @Override
    public Order getOrderById(Integer id) {
        return orderService.getOrderById(id);
    }

    @Override
    public List<Order> getListOrders() {
        return orderService.getListOrders();
    }

    @Override
    public void updateOrder(Order order) {
        orderService.update(order);
    }

    public void importOrder() {
        synchronized (orderService) {
            List<Order> orders = importer.importOrders();

            Integer id = 1;

            for (Order order : orders) {
                if (hotel.getOrderById(id) != null) {
                    if (hotel.getOrderById(id).getId().equals(order.getId())) {
                        hotel.updateOrder(order);
                    }
                } else {
                    hotel.addOrder(order);
                }
                id++;
            }
        }
    }

    @Override
    public void exportOrders() {
        synchronized (orderService) {
            exporter.exportOrders(this.orderService.getAll());
        }
    }

    //Services
    @Override
    public void addUsedService(UsedService service) {
        usedService.add(service);
    }

    @Override
    public UsedService getServiceById(Integer id) {
        return usedService.getUsedServiceById(id);
    }

    @Override
    public List<UsedService> getListUsedServices() {
        return usedService.getListUsedServices();
    }

    @Override
    public List<UsedService> getServiceByGuest(Guest guest) {
        return guestService.getServiceByGuest(guest);
    }

    @Override
    public void updateService(UsedService service) {
        usedService.update(service);
    }

    @Override
    public List<UsedService> sortUsedServicesByPrice() {
        return usedService.sortUsedServicesByPrice();
    }


    @Override
    public void exportServices() {
        synchronized (usedService) {
            exporter.exportServices(this.usedService.getAll());
        }
    }

    @Override
    public void exportAll() {
        exporter.exportAll(this.getAllGuest(), this.getListOrders(), this.getAllRooms(), this.getListUsedServices());
    }

    public void fillDataObjects() {
        Wrapper wrapper = (Wrapper) writeModel.loadModel(PATH);

        if (wrapper != null) {
            convertWrapperToModel(wrapper);
        }
    }

    private void convertWrapperToModel(Wrapper wrapper) {
        guestService.setGuestList(wrapper.getGuests());
        roomService.setRoomList(wrapper.getRooms());
        usedService.setServicesList(wrapper.getServices());
        orderService.setOrdersList(wrapper.getOrders());
    }
}
