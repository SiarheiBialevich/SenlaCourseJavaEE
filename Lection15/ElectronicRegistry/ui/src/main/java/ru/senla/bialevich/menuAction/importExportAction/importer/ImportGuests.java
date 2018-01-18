package ru.senla.bialevich.menuAction.importExportAction.importer;

import org.apache.log4j.Logger;
import ru.senla.bialevich.menuAction.AbstractAction;
import ru.senla.bialevich.request.src.ru.senla.bialevich.DataPackage;
import ru.senla.bialevich.request.src.ru.senla.bialevich.IRequestHandler;
import ru.senla.bialevich.ui.IAction;

public class ImportGuests extends AbstractAction implements IAction {
    private static final Logger LOG = Logger.getLogger(ImportGuests.class);

    @Override
    public void execute(IRequestHandler requestHandler) {
        try {
            DataPackage dataPackage = new DataPackage("importGuests", null);
            requestHandler.sendRequest(dataPackage);
            System.out.println("Guests have successfully imported.");
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
    }
}
