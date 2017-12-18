package ru.senla.bialevich.menuAction.importExportAction.exporter;

import org.apache.log4j.Logger;
import ru.senla.bialevich.model.Registration;
import ru.senla.bialevich.menuAction.AbstractAction;
import ru.senla.bialevich.request.src.ru.senla.bialevich.DataPackage;
import ru.senla.bialevich.request.src.ru.senla.bialevich.IRequestHandler;
import ru.senla.bialevich.ui.IAction;

import java.util.List;

public class ExportOrders extends AbstractAction implements IAction {
    private static final Logger LOG = Logger.getLogger(ExportOrders.class);

    @Override
    public void execute(IRequestHandler requestHandler) {
        try {
            DataPackage dataPackage = new DataPackage("getAllOrders", null);
            List<Registration> registrations = (List<Registration>) requestHandler.sendRequest(dataPackage);
            if (registrations.size() == 0) {
                System.out.println("Orders is missing.");
            } else {
                dataPackage = new DataPackage("exportOrders", null);
                requestHandler.sendRequest(dataPackage);
                System.out.println("Orders have successfully exported.");
            }
        } catch (Exception e) {
            LOG.error(e.getMessage());
        }
    }
}
