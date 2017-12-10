package ru.senla.bialevich.menuAction.roomAction;

import org.apache.log4j.Logger;
import ru.senla.bialevich.entity.Room;
import ru.senla.bialevich.menuAction.AbstractAction;
import ru.senla.bialevich.request.src.ru.senla.bialevich.DataPackage;
import ru.senla.bialevich.request.src.ru.senla.bialevich.IRequestHandler;
import ru.senla.bialevich.ui.IAction;
import ru.senla.bialevich.util.Printer;

import java.util.List;

public class GetAllRooms extends AbstractAction implements IAction {
    private static final Logger log = Logger.getLogger(GetAllRooms.class);

    @Override
    public void execute(IRequestHandler requestHandler) {
        Printer printer = new Printer();

        try {
            DataPackage dataPackage = new DataPackage("getAllRooms", null);
            List<Room> rooms = (List<Room>) requestHandler.sendRequest(dataPackage);
            if (rooms == null || rooms.size() == 0) {
                printer.print("Rooms not found.");
            } else {
                printer.print(rooms);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}
