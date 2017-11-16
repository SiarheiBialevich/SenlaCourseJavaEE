package ru.senla.bialevich.menuAction.guestAction;

import org.apache.log4j.Logger;
import ru.senla.bialevich.DataPackage;
import ru.senla.bialevich.IRequestHandler;
import ru.senla.bialevich.api.IAction;
import ru.senla.bialevich.entity.Guest;
import ru.senla.bialevich.menuAction.AbstractAction;
import ru.senla.bialevich.util.Printer;

import java.util.List;

public class GetAllGuests extends AbstractAction implements IAction {
    private static final Logger log = Logger.getLogger(GetAllGuests.class);

    @Override
    public void execute(IRequestHandler requestHandler) {
        Printer printer = new Printer();

        try {
            DataPackage dataPackage = new DataPackage("getAllGuests", null);
            List<Guest> guests = (List<Guest>) requestHandler.sendRequest(dataPackage);
            if (guests == null || guests.size() == 0) {
                printer.print("Guest not found");
            } else {
                printer.print(guests);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}
