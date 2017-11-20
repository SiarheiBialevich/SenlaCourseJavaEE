package ru.senla.bialevich.menuAction.roomAction.sort;

import org.apache.log4j.Logger;
import ru.senla.bialevich.DataPackage;
import ru.senla.bialevich.IRequestHandler;
import ru.senla.bialevich.ui.IAction;
import ru.senla.bialevich.entity.Room;
import ru.senla.bialevich.menuAction.AbstractAction;
import ru.senla.bialevich.util.Printer;

import java.util.List;

public class SortRoomByStars extends AbstractAction implements IAction {
    private static final Logger log = Logger.getLogger(SortRoomByStars.class);

    @Override
    public void execute(IRequestHandler requestHandler) {
        Printer printer = new Printer();

        DataPackage dataPackage = new DataPackage("getSortedRoomsByStars", null);
        List<Room> rooms = (List<Room>) requestHandler.sendRequest(dataPackage);

        if (rooms == null) {
            printer.print("Rooms not found.");
        } else {
            printer.print(rooms);
        }
    }
}
