package ru.senla.bialevich.menuAction.roomAction;

import org.apache.log4j.Logger;
import ru.senla.bialevich.IRequestHandler;
import ru.senla.bialevich.api.IAction;
import ru.senla.bialevich.menuAction.AbstractAction;
import ru.senla.bialevich.util.Printer;

public class TotalFreeRooms extends AbstractAction implements IAction {
    private static final Logger log = Logger.getLogger(TotalFreeRooms.class);

    @Override
    public void execute(IRequestHandler requestHandler) {
        Printer printer = new Printer();

        try {
            printer.print(hotel.getTotalFreeNumberOfRooms());
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}
