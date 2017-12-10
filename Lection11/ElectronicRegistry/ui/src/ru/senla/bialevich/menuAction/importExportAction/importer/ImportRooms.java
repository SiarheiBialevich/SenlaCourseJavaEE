package ru.senla.bialevich.menuAction.importExportAction.importer;

import org.apache.log4j.Logger;
import ru.senla.bialevich.menuAction.AbstractAction;
import ru.senla.bialevich.request.src.ru.senla.bialevich.DataPackage;
import ru.senla.bialevich.request.src.ru.senla.bialevich.IRequestHandler;
import ru.senla.bialevich.ui.IAction;
import ru.senla.bialevich.util.Printer;

public class ImportRooms extends AbstractAction implements IAction {
    private static final Logger LOG = Logger.getLogger(ImportRooms.class);
    private Printer printer = new Printer();

    @Override
    public void execute(IRequestHandler requestHandler) {
        try {
            DataPackage dataPackage = new DataPackage("importRoom", null);
            requestHandler.sendRequest(dataPackage);
            printer.print("Rooms have successfully imported.");
        } catch (Exception e) {
            LOG.error(e.getMessage());
        }
    }
}
