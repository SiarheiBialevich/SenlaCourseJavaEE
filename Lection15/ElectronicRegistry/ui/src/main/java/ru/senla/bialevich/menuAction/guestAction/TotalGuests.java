package ru.senla.bialevich.menuAction.guestAction;

import org.apache.log4j.Logger;
import ru.senla.bialevich.menuAction.AbstractAction;
import ru.senla.bialevich.request.src.ru.senla.bialevich.DataPackage;
import ru.senla.bialevich.request.src.ru.senla.bialevich.IRequestHandler;
import ru.senla.bialevich.ui.IAction;

public class TotalGuests extends AbstractAction implements IAction {
    private static final Logger log = Logger.getLogger(TotalGuests.class);

    @Override
    public void execute(IRequestHandler requestHandler) {

        try {
            DataPackage dataPackage = new DataPackage("getCountGuest", null);
            Integer count = (Integer) requestHandler.sendRequest(dataPackage);
            if (count == 0) {
                System.out.println("Guests not found.");
            } else {
                System.out.println(count);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}
