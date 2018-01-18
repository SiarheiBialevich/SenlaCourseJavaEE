package ru.senla.bialevich.menuAction.guestAction;

import org.apache.log4j.Logger;
import ru.senla.bialevich.model.Guest;
import ru.senla.bialevich.menuAction.AbstractAction;
import ru.senla.bialevich.request.src.ru.senla.bialevich.DataPackage;
import ru.senla.bialevich.request.src.ru.senla.bialevich.IRequestHandler;
import ru.senla.bialevich.ui.IAction;

import java.util.List;

public class GetAllGuests extends AbstractAction implements IAction {
    private static final Logger log = Logger.getLogger(GetAllGuests.class);

    @Override
    public void execute(IRequestHandler requestHandler) {

        try {
            DataPackage dataPackage = new DataPackage("getAllGuests", null);
            List<Guest> guests = (List<Guest>) requestHandler.sendRequest(dataPackage);
            if (guests == null || guests.size() == 0) {
                System.out.println("Guest not found");
            } else {
                System.out.println(guests);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}
