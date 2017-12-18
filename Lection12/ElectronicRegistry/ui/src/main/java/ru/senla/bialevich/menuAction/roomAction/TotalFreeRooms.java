package ru.senla.bialevich.menuAction.roomAction;

import org.apache.log4j.Logger;
import ru.senla.bialevich.menuAction.AbstractAction;
import ru.senla.bialevich.request.src.ru.senla.bialevich.DataPackage;
import ru.senla.bialevich.request.src.ru.senla.bialevich.IRequestHandler;
import ru.senla.bialevich.ui.IAction;


public class TotalFreeRooms extends AbstractAction implements IAction {
    private static final Logger log = Logger.getLogger(TotalFreeRooms.class);

    @Override
    public void execute(IRequestHandler requestHandler) {

        try {
            DataPackage dataPackage = new DataPackage("getAllRooms", null);
            Integer count = (Integer) requestHandler.sendRequest(dataPackage);
            if (count == 0) {
                System.out.println("Not free rooms");
            } else {
                System.out.println(String.valueOf(count));
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }
}
