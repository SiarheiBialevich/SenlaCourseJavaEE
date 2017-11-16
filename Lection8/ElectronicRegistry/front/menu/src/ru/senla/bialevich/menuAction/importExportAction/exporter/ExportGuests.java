package ru.senla.bialevich.menuAction.importExportAction.exporter;

import org.apache.log4j.Logger;
import ru.senla.bialevich.DataPackage;
import ru.senla.bialevich.IRequestHandler;
import ru.senla.bialevich.api.IAction;
import ru.senla.bialevich.entity.Guest;
import ru.senla.bialevich.menuAction.AbstractAction;
import ru.senla.bialevich.util.Printer;

import java.util.List;

public class ExportGuests extends AbstractAction implements IAction {
    private static final Logger LOG = Logger.getLogger(ExportGuests.class);
    private Printer printer = new Printer();

    @Override
    public void execute(IRequestHandler requestHandler) {
        try {
            DataPackage dataPackage = new DataPackage("getAllGuests", null);
            List<Guest> guests = (List<Guest>) requestHandler.sendRequest(dataPackage);
            if (guests.size() == 0) {
                printer.print("Guests is missing.");
            } else {
                dataPackage = new DataPackage("exportGuests", null);
                requestHandler.sendRequest(dataPackage);
                printer.print("Guests have successfully exported.");
            }
        } catch (Exception e) {
            LOG.error(e.getMessage());
            e.printStackTrace();
        }
    }
}
