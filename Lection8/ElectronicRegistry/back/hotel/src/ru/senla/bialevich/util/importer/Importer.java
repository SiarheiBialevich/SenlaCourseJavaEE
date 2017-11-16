package ru.senla.bialevich.util.importer;

import org.apache.log4j.Logger;
import ru.senla.bialevich.ClassSetting;
import ru.senla.bialevich.dependency.DependencyInjection;
import ru.senla.bialevich.entity.Guest;
import ru.senla.bialevich.entity.Order;
import ru.senla.bialevich.entity.Room;
import ru.senla.bialevich.menuAction.AbstractAction;
import ru.senla.bialevich.util.converter.api.IConverter;
import ru.senla.bialevich.util.serialization.WriteObject;

import java.util.ArrayList;
import java.util.List;

public class Importer extends AbstractAction {
    private static final Logger LOG = Logger.getLogger(Importer.class);
    private static final String PATH = ClassSetting.getInstance().getProperty("path.to.entity.file");

    private IConverter converter;
    private WriteObject wObject = new WriteObject();

    public Importer() {
        converter = (IConverter) DependencyInjection.getInjection().getInstance(IConverter.class);
    }

    public List<Guest> importGuests() {
        List<String> strings = wObject.readFile(PATH);

        List<Guest> guests = new ArrayList<>();
        for (String string : strings) {
            guests.add(converter.convertStringToGuest(string));
        }

        return guests;
    }

    public List<Room> importRooms() {
        List<String> strings = wObject.readFile(PATH);

        List<Room> rooms = new ArrayList<>();
        for (String string : strings) {
            rooms.add(converter.convertStringToRoom(string));
        }

        return rooms;
    }

    public List<Order> importOrders() {
        List<String> strings = wObject.readFile(PATH);

        List<Order> orders = new ArrayList<>();
        for (String string : strings) {
            orders.add(converter.convertStringToOrder(string));
        }

        return orders;
    }
}
