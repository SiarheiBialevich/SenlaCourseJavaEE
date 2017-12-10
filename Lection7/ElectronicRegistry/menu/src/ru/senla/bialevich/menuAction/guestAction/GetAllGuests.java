package ru.senla.bialevich.menuAction.guestAction;

import org.apache.log4j.Logger;
import ru.senla.bialevich.api.IAction;
import ru.senla.bialevich.menuAction.AbstractAction;
import ru.senla.bialevich.util.Printer;

public class GetAllGuests extends AbstractAction implements IAction {
    private static final Logger log = Logger.getLogger(GetAllGuests.class);

    @Override
    public void execute() {
        Printer printer = new Printer();

        try {
            if (hotel.getAllGuest() == null || hotel.getAllGuest().size() == 0) {
                printer.print("Guest not found");
            } else {
                printer.print(hotel.getAllGuest());
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}
