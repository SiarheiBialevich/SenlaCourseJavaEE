package ru.senla.bialevich.menuAction.roomAction;

import org.apache.log4j.Logger;
import ru.senla.bialevich.model.Room;
import ru.senla.bialevich.enums.RoomSection;
import ru.senla.bialevich.menuAction.AbstractAction;
import ru.senla.bialevich.request.src.ru.senla.bialevich.DataPackage;
import ru.senla.bialevich.request.src.ru.senla.bialevich.IRequestHandler;
import ru.senla.bialevich.ui.IAction;
import ru.senla.bialevich.util.InputReader;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddRoom extends AbstractAction implements IAction {
    private static final Logger log = Logger.getLogger(AddRoom.class);

    @Override
    public void execute(IRequestHandler requestHandler) {
        Scanner scanner = new Scanner(System.in);

        try {
            List<Object> objects = new ArrayList<>();
            Double price = InputReader.getInputDouble(scanner, "Input price: ");
            Integer capacity = InputReader.getInputInt(scanner, "Input capacity: ");
            String strSection = InputReader.getInputString(scanner, "Input room section: ");
            RoomSection section = RoomSection.isExist(strSection.toUpperCase());
            Integer rating = InputReader.getInputInt(scanner, "Input rating: ");
            Room room = new Room(price, capacity, section, rating);
            objects.add(room);
            DataPackage dataPackage = new DataPackage("addRoom", room);
            requestHandler.sendRequest(dataPackage);

            System.out.println("Room created.");
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}
