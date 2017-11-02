package ru.senla.bialevich.util.exporter;

import ru.senla.bialevich.ClassSetting;
import ru.senla.bialevich.entity.Guest;
import ru.senla.bialevich.entity.Order;
import ru.senla.bialevich.entity.Room;
import ru.senla.bialevich.entity.UsedService;
import ru.senla.bialevich.util.converter.Converter;
import ru.senla.bialevich.util.serialization.WriteModel;
import ru.senla.bialevich.util.serialization.WriteObject;
import ru.senla.bialevich.util.wrapper.Wrapper;

import java.util.List;

public class Exporter {
    private Converter converter;
    private WriteModel writeModel;
    private WriteObject writeObject;
    private Wrapper wrapper;

    private static final String PATH = ClassSetting.getInstance().getProperty("main.file");

    public Exporter(WriteObject writeObject) {
        this.converter = new Converter();
        this.writeObject = writeObject;
        this.writeModel = new WriteModel();
    }

    public void exportGuests(List<Guest> guests) {
        String[] values = new String[guests.size()];
        for (int i = 0; i < values.length; i++) {
            values[i] = converter.convertGuestToString(guests.get(i));
        }
        writeObject.writeObject(values);
    }

    public void exportOrders(List<Order> orders) {
        String[] values = new String[orders.size()];
        for (int i = 0; i < values.length; i++) {
            values[i] = converter.convertOrderToString(orders.get(i));
        }
        writeObject.writeObject(values);
    }

    public void exportRooms(List<Room> rooms) {
        String[] values = new String[rooms.size()];
        for (int i = 0; i < values.length; i++) {
            values[i] = converter.convertRoomToString(rooms.get(i));
        }
        writeObject.writeObject(values);
    }

    public void exportServices(List<UsedService> services) {
        String[] values = new String[services.size()];
        for (int i = 0; i < values.length; i++) {
            values[i] = converter.convertServiceToString(services.get(i));
        }
        writeObject.writeObject(values);
    }

    public void exportAll(List<Guest> guests, List<Order> orders, List<Room> rooms, List<UsedService> services) {
        wrapper = new Wrapper();
        wrapper.setGuests(guests);
        wrapper.setRooms(rooms);
        wrapper.setOrders(orders);
        wrapper.setServices(services);

        writeModel.saveModel(wrapper, PATH);
    }

    public void exportModel() {
        wrapper = new Wrapper();
        writeModel.saveModel(wrapper, PATH);
    }
}
