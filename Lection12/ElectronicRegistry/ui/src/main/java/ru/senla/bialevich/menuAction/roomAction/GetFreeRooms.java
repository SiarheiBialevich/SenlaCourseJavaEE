package ru.senla.bialevich.menuAction.roomAction;

import org.apache.log4j.Logger;
import ru.senla.bialevich.model.Room;
import ru.senla.bialevich.menuAction.AbstractAction;
import ru.senla.bialevich.request.src.ru.senla.bialevich.DataPackage;
import ru.senla.bialevich.request.src.ru.senla.bialevich.IRequestHandler;
import ru.senla.bialevich.ui.IAction;

import java.util.List;

public class GetFreeRooms extends AbstractAction implements IAction {
    private static final Logger log = Logger.getLogger(GetFreeRooms.class);

    @Override
    public void execute(IRequestHandler requestHandler) {

        try {
            DataPackage dataPackage = new DataPackage("getFreeRooms", null);
            List<Room> rooms = (List<Room>) requestHandler.sendRequest(dataPackage);
            if (rooms == null || rooms.size() == 0) {
                System.out.println("Rooms not found.");
            } else {
                System.out.println(rooms);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}
