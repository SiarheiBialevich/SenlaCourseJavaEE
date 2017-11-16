package ru.senla.bialevich.menuAction.importExportAction.exporter;

import org.apache.log4j.Logger;
import ru.senla.bialevich.DataPackage;
import ru.senla.bialevich.IRequestHandler;
import ru.senla.bialevich.api.IAction;
import ru.senla.bialevich.menuAction.AbstractAction;
import ru.senla.bialevich.util.Printer;

public class ExportAll extends AbstractAction implements IAction {
    private static final Logger LOG = Logger.getLogger(ExportAll.class);
    private Printer printer = new Printer();

    @Override
    public void execute(IRequestHandler requestHandler) {
        try {
            DataPackage dataPackage = new DataPackage("exportAll", null);
            requestHandler.sendRequest(dataPackage);
            printer.print("Successful export.");
        } catch (Exception e) {
            LOG.error(e.getMessage());
        }
    }
}
