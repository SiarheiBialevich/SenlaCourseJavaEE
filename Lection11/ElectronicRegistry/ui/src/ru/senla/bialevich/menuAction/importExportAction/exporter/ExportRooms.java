package ru.senla.bialevich.menuAction.importExportAction.exporter;

import org.apache.log4j.Logger;
import ru.senla.bialevich.entity.Room;
import ru.senla.bialevich.menuAction.AbstractAction;
import ru.senla.bialevich.request.src.ru.senla.bialevich.DataPackage;
import ru.senla.bialevich.request.src.ru.senla.bialevich.IRequestHandler;
import ru.senla.bialevich.ui.IAction;
import ru.senla.bialevich.util.Printer;

import java.util.List;

public class ExportRooms extends AbstractAction implements IAction {
    private static final Logger LOG = Logger.getLogger(ExportRooms.class);
    private Printer printer = new Printer();

    @Override
    public void execute(IRequestHandler requestHandler) {
        try {
            DataPackage dataPackage = new DataPackage("getAllRooms", null);
            List<Room> rooms = (List<Room>) requestHandler.sendRequest(dataPackage);
            if (rooms.size() == 0) {
                printer.print("Rooms is missing.");
            } else {
                dataPackage = new DataPackage("exportRooms", null);
                requestHandler.sendRequest(dataPackage);
                printer.print("Rooms have successfully exported.");
            }
        } catch (Exception e) {
            LOG.error(e.getMessage());
        }
    }
}
