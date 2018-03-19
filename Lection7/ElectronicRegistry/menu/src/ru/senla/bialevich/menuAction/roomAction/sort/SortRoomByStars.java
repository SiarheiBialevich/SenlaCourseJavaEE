package ru.senla.bialevich.menuAction.roomAction.sort;

import org.apache.log4j.Logger;
import ru.senla.bialevich.api.IAction;
import ru.senla.bialevich.menuAction.AbstractAction;
import ru.senla.bialevich.util.Printer;

public class SortRoomByStars extends AbstractAction implements IAction {
    private static final Logger log = Logger.getLogger(SortRoomByStars.class);

    @Override
    public void execute() {
        Printer printer = new Printer();

        try {
            printer.print(hotel.sortedRoomsByCategory());
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}
