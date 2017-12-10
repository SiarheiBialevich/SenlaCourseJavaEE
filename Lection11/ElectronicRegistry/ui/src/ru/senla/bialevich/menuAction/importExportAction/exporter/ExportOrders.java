package ru.senla.bialevich.menuAction.importExportAction.exporter;

import org.apache.log4j.Logger;
import ru.senla.bialevich.entity.Registration;
import ru.senla.bialevich.menuAction.AbstractAction;
import ru.senla.bialevich.request.src.ru.senla.bialevich.DataPackage;
import ru.senla.bialevich.request.src.ru.senla.bialevich.IRequestHandler;
import ru.senla.bialevich.ui.IAction;
import ru.senla.bialevich.util.Printer;

import java.util.List;

public class ExportOrders extends AbstractAction implements IAction {
    private static final Logger LOG = Logger.getLogger(ExportOrders.class);
    private Printer printer = new Printer();

    @Override
    public void execute(IRequestHandler requestHandler) {
        try {
            DataPackage dataPackage = new DataPackage("getAllOrders", null);
            List<Registration> registrations = (List<Registration>) requestHandler.sendRequest(dataPackage);
            if (registrations.size() == 0) {
                printer.print("Orders is missing.");
            } else {
                dataPackage = new DataPackage("exportOrders", null);
                requestHandler.sendRequest(dataPackage);
                printer.print("Orders have successfully exported.");
            }
        } catch (Exception e) {
            LOG.error(e.getMessage());
        }
    }
}
