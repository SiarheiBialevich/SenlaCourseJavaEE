package ru.senla.bialevich.menuAction.guestAction;

import org.apache.log4j.Logger;
import ru.senla.bialevich.DataPackage;
import ru.senla.bialevich.IRequestHandler;
import ru.senla.bialevich.ui.IAction;
import ru.senla.bialevich.menuAction.AbstractAction;
import ru.senla.bialevich.util.Printer;

public class TotalGuests extends AbstractAction implements IAction {
    private static final Logger log = Logger.getLogger(TotalGuests.class);

    @Override
    public void execute(IRequestHandler requestHandler) {
        Printer printer = new Printer();

        try {
            DataPackage dataPackage = new DataPackage("getCountGuest", null);
            Integer count = (Integer) requestHandler.sendRequest(dataPackage);
            if (count == 0) {
                printer.print("Guests not found.");
            } else {
                printer.print(count);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}
