package ru.senla.bialevich.menuAction.importExportAction.exporter;

import org.apache.log4j.Logger;
import ru.senla.bialevich.model.Guest;
import ru.senla.bialevich.menuAction.AbstractAction;
import ru.senla.bialevich.request.src.ru.senla.bialevich.DataPackage;
import ru.senla.bialevich.request.src.ru.senla.bialevich.IRequestHandler;
import ru.senla.bialevich.ui.IAction;

import java.util.List;

public class ExportGuests extends AbstractAction implements IAction {
    private static final Logger LOG = Logger.getLogger(ExportGuests.class);
    @Override
    public void execute(IRequestHandler requestHandler) {
        try {
            DataPackage dataPackage = new DataPackage("getAllGuests", null);
            List<Guest> guests = (List<Guest>) requestHandler.sendRequest(dataPackage);
            if (guests.size() == 0) {
                System.out.println("Guests is missing.");
            } else {
                dataPackage = new DataPackage("exportGuests", null);
                requestHandler.sendRequest(dataPackage);
                System.out.println("Guests have successfully exported.");
            }
        } catch (Exception e) {
            LOG.error(e.getMessage());
            e.printStackTrace();
        }
    }
}
