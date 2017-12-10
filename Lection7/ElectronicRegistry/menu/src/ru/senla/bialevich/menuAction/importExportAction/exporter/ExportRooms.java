package ru.senla.bialevich.menuAction.importExportAction.exporter;

import org.apache.log4j.Logger;
import ru.senla.bialevich.api.IAction;
import ru.senla.bialevich.menuAction.AbstractAction;
import ru.senla.bialevich.util.Printer;

public class ExportRooms extends AbstractAction implements IAction {
    private static final Logger LOG = Logger.getLogger(ExportRooms.class);
    private Printer printer = new Printer();

    @Override
    public void execute() {
        try {
            if (hotel.getAllRooms().size() == 0) {
                printer.print("Rooms is missing.");
            } else {
                hotel.exportRooms();
                printer.print("Rooms have successfully exported.");
            }
        } catch (Exception e) {
            LOG.error(e.getMessage());
        }
    }
}
