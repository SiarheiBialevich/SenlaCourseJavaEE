package ru.senla.bialevich.menuAction.importExportAction.exporter;

import org.apache.log4j.Logger;
import ru.senla.bialevich.DataPackage;
import ru.senla.bialevich.IRequestHandler;
import ru.senla.bialevich.ui.IAction;
import ru.senla.bialevich.entity.UsedService;
import ru.senla.bialevich.menuAction.AbstractAction;
import ru.senla.bialevich.util.Printer;

import java.util.List;

public class ExportServices extends AbstractAction implements IAction {
    private static final Logger LOG = Logger.getLogger(ExportServices.class);
    private Printer printer = new Printer();

    @Override
    public void execute(IRequestHandler requestHandler) {
        try {
            DataPackage dataPackage = new DataPackage("getAllServices", null);
            List<UsedService> services = (List<UsedService>) requestHandler.sendRequest(dataPackage);
            if (services.size() == 0) {
                printer.print("Services is missing.");
            } else {
                dataPackage = new DataPackage("exportServices", null);
                requestHandler.sendRequest(dataPackage);
                printer.print("Services have successfully exported.");
            }
        } catch (Exception e) {
            LOG.error(e.getMessage());
        }
    }
}
