package ru.senla.bialevich.menuAction.roomAction.sort;

import org.apache.log4j.Logger;
import ru.senla.bialevich.model.Room;
import ru.senla.bialevich.menuAction.AbstractAction;
import ru.senla.bialevich.request.src.ru.senla.bialevich.DataPackage;
import ru.senla.bialevich.request.src.ru.senla.bialevich.IRequestHandler;
import ru.senla.bialevich.ui.IAction;

import java.util.List;

public class SortRoomsByPrice extends AbstractAction implements IAction {
    private static final Logger log = Logger.getLogger(SortRoomsByPrice.class);

    @Override
    public void execute(IRequestHandler requestHandler) {

        DataPackage dataPackage = new DataPackage("getSortedRoomsByPrice", null);
        List<Room> rooms = (List<Room>) requestHandler.sendRequest(dataPackage);

        if (rooms == null) {
            System.out.println("Rooms not found.");
        } else {
            System.out.println(rooms);
        }
    }
}
