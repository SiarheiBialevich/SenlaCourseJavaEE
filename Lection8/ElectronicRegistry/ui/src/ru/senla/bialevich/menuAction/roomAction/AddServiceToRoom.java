package ru.senla.bialevich.menuAction.roomAction;

import org.apache.log4j.Logger;
import ru.senla.bialevich.DataPackage;
import ru.senla.bialevich.IRequestHandler;
import ru.senla.bialevich.ui.IAction;
import ru.senla.bialevich.entity.Room;
import ru.senla.bialevich.entity.UsedService;
import ru.senla.bialevich.menuAction.AbstractAction;
import ru.senla.bialevich.util.InputReader;
import ru.senla.bialevich.util.Printer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddServiceToRoom extends AbstractAction implements IAction {
    private static final Logger log = Logger.getLogger(AddServiceToRoom.class);
    private Printer printer = new Printer();

    @Override
    public void execute(IRequestHandler requestHandler) {
        Scanner scanner = new Scanner(System.in);
        Integer idRoom = InputReader.getInputInt(scanner, "Enter ID the room.");
        Integer idService = InputReader.getInputInt(scanner, "Enter ID the used serialization.");

        try {
            DataPackage dataPackage = new DataPackage("getRoom", idRoom);
            Room room = (Room) requestHandler.sendRequest(dataPackage);

            dataPackage = new DataPackage("getServices", idService);
            UsedService service = (UsedService) requestHandler.sendRequest(dataPackage);

            if (room == null || service == null) {
                printer.print("Room or services not found");
            } else {
                List<Object> params = new ArrayList<>();
                params.add(room);
                params.add(service);

                dataPackage = new DataPackage("addServiceToRoom", params);
                requestHandler.sendRequest(dataPackage);
                printer.print("Service settled.");
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }
}
