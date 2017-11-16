package ru.senla.bialevich.controller;

import ru.senla.bialevich.ClassSetting;
import ru.senla.bialevich.annotations.AnnotationWorker;
import ru.senla.bialevich.annotations.ConfigProperty;
import ru.senla.bialevich.api.controller.ControllerHotel;
import ru.senla.bialevich.api.service.GuestService;
import ru.senla.bialevich.api.service.OrderService;
import ru.senla.bialevich.api.service.RoomService;
import ru.senla.bialevich.api.service.UsedServiceService;
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

import java.util.List;

public class ControllerHotelImpl implements ControllerHotel {

    private static final String PATH = ClassSetting.getInstance().getProperty("main.file");

    @ConfigProperty(configName = "property\\resources\\annotation.properties", propertyName = "block.status", type = Boolean.class)
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
        Guest guest = null;
        synchronized (guestService) {
            guest = guestService.getGuestById(id);
        }
        return guest;
    }

    @Override
    public List<Guest> getAllGuest() {
        List<Guest> guests = null;
        synchronized (guestService) {
            guests = guestService.getAll();
        }
        return guests;
    }

    @Override
    public void updateGuest(Guest guest) {
        synchronized (guestService) {
            guestService.update(guest);
        }
    }

    @Override
    public Integer getTotalNumberOfGuests() {
        Integer totalGuest = null;
        synchronized (guestService) {
            totalGuest = guestService.getTotalNumberOfGuests();
        }
        return totalGuest;
    }

    @Override
    public List<Guest> sortedGuestsBySurname() {
        List<Guest> guests = null;
        synchronized (guestService) {
            guests = guestService.sortedGuestsBySurname();
        }
        return guests;
    }

    @Override
    public List<Guest> sortedGuestsByDateOfDeparture() {
        List<Guest> guests = null;
        synchronized (guestService) {
            guests = guestService.sortedGuestsByDateOfDeparture();
        }
        return guests;
    }

    @Override
    public List<Guest> getListGuests() {
        List<Guest> guests = null;
        synchronized (guestService) {
            guests = guestService.getListGuests();
        }
        return guests;
    }

    @Override
    public void setOrderToGuest(Guest guest, Order order) {
        synchronized (guestService) {
            guestService.setOrderToGuest(guest, order);
        }
    }

    public void setRoomToGuest(Guest guest, Room room) {
        synchronized (guestService) {
            guestService.setRoomToGuest(guest, room);
        }
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
        synchronized (roomService) {
            roomService.add(room);
        }
    }

    @Override
    public Room getRoomById(Integer id) {
        Room room = null;
        synchronized (roomService) {
            room = roomService.getRoomById(id);
        }
        return room;
    }

    @Override
    public List<Room> getFreeRooms() {
        List<Room> rooms = null;
        synchronized (roomService) {
            rooms = roomService.getFreeRooms();
        }
        return rooms;
    }

    @Override
    public List<Room> getTotalFreeNumberOfRooms() {
        List<Room> rooms = null;
        synchronized (roomService) {
            rooms = roomService.getFreeRooms();
        }
        return rooms;
    }

    @Override
    public Float getRoomTotalPrice(Room room) {
        Float price = null;
        synchronized (roomService) {
            price = roomService.getTotalPrice(room);
        }
        return price;
    }

    @Override
    public List<Room> getAllRooms() {
        List<Room> rooms = null;
        synchronized (roomService) {
            rooms = roomService.getAll();
        }
        return rooms;
    }

    @Override
    public List<Room> getListRooms() {
        List<Room> rooms = null;
        synchronized (roomService) {
            rooms = roomService.getListRooms();
        }
        return rooms;
    }

    @Override
    public void registerGuestInRoom(Guest guest, Room room) {
        synchronized (roomService) {
            roomService.registerGuestInRoom(guest, room);
        }
    }

    @Override
    public boolean changeRoomStatus(Room room) {
        synchronized (roomService) {

            if (isProps) {
                room.setFree(false);
                roomService.update(room);
                return true;
            }
            return false;
        }
    }

    @Override
    public void changeRoomPrice(Room room, Float value) {
        synchronized (roomService) {
            room.setPrice(value);
            roomService.update(room);
        }
    }

    @Override
    public void updateRoom(Room room) {
        synchronized (roomService) {
            roomService.update(room);
        }
    }

    public Room cloneRoom(Integer id) {
        Room room = null;
        synchronized (roomService) {
            room = roomService.cloneRoom(id);
        }
        return room;
    }

    @Override
    public List<Room> sortedRoomsByPrice() {
        List<Room> rooms = null;
        synchronized (roomService) {
            rooms = roomService.sortedRoomsByPrice();
        }
        return rooms;
    }

    @Override
    public List<Room> sortedRoomsByCountBegs() {
        List<Room> rooms = null;
        synchronized (roomService) {
            rooms = roomService.sortedRoomsByCountBegs();
        }
        return rooms;
    }

    @Override
    public List<Room> sortedRoomsByCategory() {
        List<Room> rooms = null;
        synchronized (roomService) {
            rooms = roomService.sortedRoomsByCategory();
        }
        return rooms;
    }

    @Override
    public List<Room> sortedFreeRoomsByPrice() {
        List<Room> rooms = null;
        synchronized (roomService) {
            rooms = roomService.sortedFreeRoomsByPrice();
        }
        return rooms;
    }

    @Override
    public List<Room> sortedFreeRoomsByCountBegs() {
        List<Room> rooms = null;
        synchronized (roomService) {
            rooms = roomService.sortedFreeRoomsByCountBegs();
        }
        return rooms;
    }

    @Override
    public List<Room> sortedFreeRoomsByCategory() {
        List<Room> rooms = null;
        synchronized (roomService) {
            rooms = roomService.sortedFreeRoomsByCategory();
        }
        return rooms;
    }

    @Override
    public void setServiceToRoom(Room room, UsedService service) {
        synchronized (roomService) {
            roomService.setServiceToRoom(room, service);
        }
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
        synchronized (orderService) {
            orderService.add(order);
        }
    }

    @Override
    public Order getOrderById(Integer id) {
        Order order = null;
        synchronized (orderService) {
            order = orderService.getOrderById(id);
        }
        return order;
    }

    @Override
    public List<Order> getListOrders() {
        List<Order> orders = null;
        synchronized (orderService) {
            orders = orderService.getListOrders();
        }
        return orders;
    }

    @Override
    public void updateOrder(Order order) {
        synchronized (orderService) {
            orderService.update(order);
        }
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
        UsedService service = null;
        synchronized (usedService) {
            service = usedService.getUsedServiceById(id);
        }
        return service;
    }

    @Override
    public List<UsedService> getListUsedServices() {
        List<UsedService> services = null;
        synchronized (usedService) {
            services = usedService.getListUsedServices();
        }
        return services;
    }

    @Override
    public List<UsedService> getServiceByGuest(Guest guest) {
        List<UsedService> services = null;
        synchronized (usedService) {
            services = guestService.getServiceByGuest(guest);
        }
        return services;
    }

    @Override
    public void updateService(UsedService service) {
        synchronized (usedService) {
            usedService.update(service);
        }
    }

    @Override
    public List<UsedService> sortUsedServicesByPrice() {
        List<UsedService> services = null;
        synchronized (usedService) {
            services = usedService.sortUsedServicesByPrice();
        }
        return services;
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
