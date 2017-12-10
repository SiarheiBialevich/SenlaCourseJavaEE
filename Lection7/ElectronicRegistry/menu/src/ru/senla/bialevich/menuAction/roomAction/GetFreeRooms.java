package ru.senla.bialevich.menuAction.roomAction;

import org.apache.log4j.Logger;
import ru.senla.bialevich.api.IAction;
import ru.senla.bialevich.menuAction.AbstractAction;
import ru.senla.bialevich.util.Printer;

public class GetFreeRooms extends AbstractAction implements IAction {
    private static final Logger log = Logger.getLogger(GetFreeRooms.class);

    @Override
    public void execute() {
        Printer printer = new Printer();

        try {
            printer.print(hotel.getFreeRooms());
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}
