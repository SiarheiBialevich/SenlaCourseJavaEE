package ru.senla.bialevich.menuAction.roomAction;

import org.apache.log4j.Logger;
import ru.senla.bialevich.model.Room;
import ru.senla.bialevich.model.Service;
import ru.senla.bialevich.menuAction.AbstractAction;
import ru.senla.bialevich.request.src.ru.senla.bialevich.DataPackage;
import ru.senla.bialevich.request.src.ru.senla.bialevich.IRequestHandler;
import ru.senla.bialevich.ui.IAction;
import ru.senla.bialevich.util.InputReader;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddServiceToRoom extends AbstractAction implements IAction {
    private static final Logger log = Logger.getLogger(AddServiceToRoom.class);

    @Override
    public void execute(IRequestHandler requestHandler) {
        Scanner scanner = new Scanner(System.in);
        Integer idRoom = InputReader.getInputInt(scanner, "Enter ID the room.");
        Integer idService = InputReader.getInputInt(scanner, "Enter ID the used service.");

        try {
            DataPackage dataPackage = new DataPackage("getRoom", idRoom);
            Room room = (Room) requestHandler.sendRequest(dataPackage);

            dataPackage = new DataPackage("getServices", idService);
            Service service = (Service) requestHandler.sendRequest(dataPackage);

            if (room == null || service == null) {
                System.out.println("Room or services not found");
            } else {
                List<Object> params = new ArrayList<>();
                params.add(room);
                params.add(service);

                dataPackage = new DataPackage("addServiceToRoom", params);
                requestHandler.sendRequest(dataPackage);
                System.out.println("Service settled.");
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }
}
