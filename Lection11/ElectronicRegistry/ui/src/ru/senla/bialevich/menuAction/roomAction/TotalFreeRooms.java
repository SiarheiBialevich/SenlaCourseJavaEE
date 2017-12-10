package ru.senla.bialevich.menuAction.roomAction;

import org.apache.log4j.Logger;
import ru.senla.bialevich.menuAction.AbstractAction;
import ru.senla.bialevich.request.src.ru.senla.bialevich.DataPackage;
import ru.senla.bialevich.request.src.ru.senla.bialevich.IRequestHandler;
import ru.senla.bialevich.ui.IAction;
import ru.senla.bialevich.util.Printer;


public class TotalFreeRooms extends AbstractAction implements IAction {
    private static final Logger log = Logger.getLogger(TotalFreeRooms.class);

    @Override
    public void execute(IRequestHandler requestHandler) {
        Printer printer = new Printer();

        try {
            DataPackage dataPackage = new DataPackage("getAllRooms", null);
            Integer count = (Integer) requestHandler.sendRequest(dataPackage);
            if (count == 0) {
                printer.print("Not free rooms");
            } else {
                printer.print(String.valueOf(count));
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }
}
