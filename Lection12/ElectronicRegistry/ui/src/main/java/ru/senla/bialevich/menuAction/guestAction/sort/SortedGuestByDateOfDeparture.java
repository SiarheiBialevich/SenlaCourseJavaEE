package ru.senla.bialevich.menuAction.guestAction.sort;

import org.apache.log4j.Logger;
import ru.senla.bialevich.model.Guest;
import ru.senla.bialevich.menuAction.AbstractAction;
import ru.senla.bialevich.request.src.ru.senla.bialevich.DataPackage;
import ru.senla.bialevich.request.src.ru.senla.bialevich.IRequestHandler;
import ru.senla.bialevich.ui.IAction;


import java.util.List;

public class SortedGuestByDateOfDeparture extends AbstractAction implements IAction {
    private static final Logger LOG = Logger.getLogger(SortedGuestBySurname.class);

    @Override
    public void execute(IRequestHandler requestHandler) {
        try {
            DataPackage dataPackage = new DataPackage("getSortedByDate", null);
            List<Guest> guests = (List<Guest>) requestHandler.sendRequest(dataPackage);

            if (guests == null) {
                System.out.println("Guest not found");
            } else {
                System.out.println(guests);
            }
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
    }
}
