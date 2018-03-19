package ru.senla.bialevich.menuAction.importExportAction.exporter;

import org.apache.log4j.Logger;
import ru.senla.bialevich.model.Room;
import ru.senla.bialevich.menuAction.AbstractAction;
import ru.senla.bialevich.request.src.ru.senla.bialevich.DataPackage;
import ru.senla.bialevich.request.src.ru.senla.bialevich.IRequestHandler;
import ru.senla.bialevich.ui.IAction;
import java.util.List;

public class ExportRooms extends AbstractAction implements IAction {
    private static final Logger LOG = Logger.getLogger(ExportRooms.class);

    @Override
    public void execute(IRequestHandler requestHandler) {
        try {
            DataPackage dataPackage = new DataPackage("getAllRooms", null);
            List<Room> rooms = (List<Room>) requestHandler.sendRequest(dataPackage);
            if (rooms.size() == 0) {
                System.out.println("Rooms is missing.");
            } else {
                dataPackage = new DataPackage("exportRooms", null);
                requestHandler.sendRequest(dataPackage);
                System.out.println("Rooms have successfully exported.");
            }
        } catch (Exception e) {
            LOG.error(e.getMessage());
        }
    }
}
