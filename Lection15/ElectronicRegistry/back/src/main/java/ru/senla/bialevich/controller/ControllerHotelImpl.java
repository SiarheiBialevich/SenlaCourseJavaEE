package ru.senla.bialevich.controller;

import ru.senla.bialevich.ClassSetting;
import ru.senla.bialevich.annotations.AnnotationWorker;

import ru.senla.bialevich.dao.GuestDao;
import ru.senla.bialevich.dao.RegistrationDao;
import ru.senla.bialevich.dao.RoomDao;
import ru.senla.bialevich.dao.ServiceDao;
import ru.senla.bialevich.dependency.DependencyInjection;
import ru.senla.bialevich.model.Guest;
import ru.senla.bialevich.model.Registration;
import ru.senla.bialevich.model.Room;
import ru.senla.bialevich.model.Service;
import ru.senla.bialevich.enums.RoomStatus;
import ru.senla.bialevich.enums.SortType;
import ru.senla.bialevich.util.exporter.Exporter;
import ru.senla.bialevich.util.importer.Importer;
import ru.senla.bialevich.util.serialization.WriteObject;
import ru.senla.bialevich.service.GuestService;
import ru.senla.bialevich.service.RegistrationService;
import ru.senla.bialevich.service.RoomService;
import ru.senla.bialevich.service.ServiceService;

import java.util.Date;
import java.util.List;

public class ControllerHotelImpl implements ControllerHotel {

    private GuestService guestService = (GuestService) DependencyInjection.getInjection().getInstance(GuestService.class);
    private RoomService roomService = (RoomService) DependencyInjection.getInjection().getInstance(RoomService.class);
    private RegistrationService registrationService = (RegistrationService) DependencyInjection.getInjection().getInstance(RegistrationService.class);
    private ServiceService serviceService = (ServiceService) DependencyInjection.getInjection().getInstance(ServiceService.class);

    private Importer importer;
    private Exporter exporter;

    private WriteObject writeObject;

    @Override
    public void init() {
        this.writeObject = new WriteObject();
        this.importer = new Importer();
        this.exporter = new Exporter(writeObject);
        AnnotationWorker.getInstance().configure(this);
    }

    //Guests
    @Override
    public Guest getGuest(int id) {
        Guest guest = null;
        synchronized (guestService) {
            guest = guestService.getGuest(id);
        }
        return guest;
    }

    @Override
    public List<Guest> getAllGuests() {
        List<Guest> guests = null;
        synchronized (guestService) {
            guests = guestService.getAll(null);
        }
        return guests;
    }

    @Override
    public void addGuest(Guest guest) {
        synchronized (guestService) {
            guestService.addGuest(guest);
        }
    }

    @Override
    public void updateGuest(Guest guest) {
        synchronized (guestService) {
            guestService.update(guest);
        }
    }

    @Override
    public List<Guest> getGuestsRoom() {
        List<Guest> guests = null;
        synchronized (guestService) {
            guests = guestService.getAll(null);
        }
        return guests;
    }

    @Override
    public int getCountGuests() {
        int count = 0;
        synchronized (guestService) {
            count = guestService.getCount();
        }
        return count;
    }

    @Override
    public List<Service> getGuestServices(Guest guest) {
        List<Service> services = null;
        synchronized (serviceService) {
            services = serviceService.getServices(guest, SortType.price);
        }
        return services;
    }

    @Override
    public List<Guest> getSortedByFinalDate() {
        List<Guest> guests = null;
        synchronized (registrationService) {
            guests = registrationService.getSortedByFinalDate();
        }
        return guests;
    }

    @Override
    public void importGuests() {
        synchronized (guestService) {
            importer.importGuests(this.guestService.getAll(null));
        }
    }

    @Override
    public void exportGuests() {
        synchronized (guestService) {
            exporter.exportGuests(guestService.getAll(null));
        }
    }

    //Room
    @Override
    public Room getRoom(int id) {
        Room room = null;
        synchronized (roomService) {
            room = roomService.getRoom(id);
        }
        return room;
    }

    @Override
    public void addRoom(Room room) {
        synchronized (roomService) {
            roomService.addRoom(room);
        }
    }

    @Override
    public List<Room> getAllRooms(SortType type) {
        List<Room> rooms = null;
        synchronized (roomService) {
            rooms = roomService.getAll(null);
        }
        return rooms;
    }

    @Override
    public List<Room> getAllFreeRooms() {
        List<Room> rooms = null;
        synchronized (roomService) {
            rooms = roomService.getAllFree(null);
        }
        return rooms;
    }

    @Override
    public void updateRoom(Room room) {
        synchronized (roomService) {
            roomService.update(room);
        }
    }

    @Override
    public void cloneRoom(int id) {
        Room room = null;
        synchronized (roomService) {
            room = roomService.cloneRoom(id);
            roomService.addRoom(room);
        }
    }

    @Override
    public int getCountFreeRooms() {
        int count = 0;
        synchronized (roomService) {
            count = roomService.getCountFreeRooms();
        }
        return count;
    }

    @Override
    public List<Room> getSortedByPrice() {
        List<Room> rooms = null;
        synchronized (roomService) {
            rooms = roomService.getAll(SortType.price);
        }
        return rooms;
    }

    @Override
    public List<Room> getSortedByCapacity() {
        List<Room> rooms = null;
        synchronized (roomService) {
            rooms = roomService.getAll(SortType.capacity);
        }
        return rooms;
    }

    @Override
    public List<Room> getSortedByRating() {
        List<Room> rooms = null;
        synchronized (roomService) {
            rooms = roomService.getAll(SortType.rating);
        }
        return rooms;
    }

    @Override
    public List<Room> getReleasedRoomsInFuture(Date date) {
        List<Room> rooms = null;
        synchronized (roomService) {
            rooms = roomService.getReleasedInFuture(date);
        }
        return rooms;
    }

    @Override
    public double getSumPaymentRoom(Guest guest, Room room) {
        double sum = 0;
        synchronized (registrationService) {
            sum = registrationService.getSumByRoom(room, guest);
        }
        return sum;
    }

    @Override
    public List<Double> getPricesRoom() {
        return null;
    }

    @Override
    public void registerGuest(Guest guest, Room room, Date startDate, Date finalDate) {
        synchronized (roomService) {
            roomService.registerGuest(guest, room, startDate, finalDate);
        }
    }

    @Override
    public void evictGuest(Guest guest) {
        synchronized (roomService) {
            roomService.evictGuest(guest);
        }
    }

    @Override
    public void changeRoomPrice(Room room, double price) {
        room.setPrice(price);
        synchronized (roomService) {
            roomService.update(room);
        }
    }

    @Override
    public boolean changeRoomStatus(Room room) {
        if (ClassSetting.getProps().isBlockStatus()) {
            room.setStatus("MAINTAINED");
            synchronized (roomService) {
                roomService.update(room);
            }
            return true;
        }
        return false;
    }

    @Override
    public void importRooms() {
        synchronized (roomService) {
            importer.importRooms(this.roomService.getAll(null));
        }
    }

    @Override
    public void exportRooms() {
        synchronized (roomService) {
            exporter.exportRooms(this.roomService.getAll(null));
        }
    }

    //Registration
    @Override
    public Registration getRegistration(int id) {
        Registration registration = null;
        synchronized (registrationService) {
            registration = registrationService.getRegistration(id);
        }
        return registration;
    }

    @Override
    public List<Registration> getAllRegistrations() {
        List<Registration> registrations = null;
        synchronized (registrationService) {
            registrations = registrationService.getAll(null);
        }
        return registrations;
    }

    @Override
    public void addRegistration(Registration registration) {
        synchronized (registrationService) {
            registrationService.addRecord(registration);
        }
    }

    @Override
    public void updateRegistration(Registration registration) {
        synchronized (registrationService) {
            registrationService.update(registration);
        }
    }

    @Override
    public void importRegistrations() {
        synchronized (registrationService) {
            importer.importRegistrations(this.registrationService.getAll(null));
        }
    }

    @Override
    public void exportRegistrations() {
        synchronized (registrationService) {
            exporter.exportOrders(this.registrationService.getAll(null));
        }
    }

    //Service
    @Override
    public Service getService(int id) {
        Service service = null;
        synchronized (serviceService) {
            service = serviceService.getService(id);
        }
        return service;
    }

    @Override
    public List<Service> getAllServices() {
        List<Service> services = null;
        synchronized (serviceService) {
            services = serviceService.getAll(null);
        }
        return services;
    }

    @Override
    public void updateService(Service service) {
        synchronized (serviceService) {
            serviceService.update(service);
        }
    }

    @Override
    public void addService(Service service) {
        synchronized (serviceService) {
            serviceService.addService(service);
        }
    }

    @Override
    public void changeServicePrice(Service service, double price) {
        service.setPrice(price);
        synchronized (serviceService) {
            serviceService.update(service);
        }
    }

    @Override
    public void importServices() {
        synchronized (serviceService) {
            importer.importServices(this.serviceService.getAll(null));
        }
    }

    @Override
    public void exportServices() {
        synchronized (serviceService) {
            exporter.exportServices(this.serviceService.getAll(null));
        }
    }

    @Override
    public void exportAll() {
        exporter.exportAll(this.getAllGuests(), this.getAllRegistrations(), this.getAllRooms(null), this.getAllServices());
    }
}
