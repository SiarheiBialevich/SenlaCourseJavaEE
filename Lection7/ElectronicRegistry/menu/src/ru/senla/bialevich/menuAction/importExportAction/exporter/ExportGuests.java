package ru.senla.bialevich.menuAction.importExportAction.exporter;

import org.apache.log4j.Logger;
import ru.senla.bialevich.api.IAction;
import ru.senla.bialevich.menuAction.AbstractAction;
import ru.senla.bialevich.util.Printer;

public class ExportGuests extends AbstractAction implements IAction {
    private static final Logger LOG = Logger.getLogger(ExportGuests.class);
    private Printer printer = new Printer();

    @Override
    public void execute() {
        try {
            if (hotel.getAllGuest().size() == 0) {
                printer.print("Guests is missing.");
            } else {
                hotel.exportGuests();
                printer.print("Guests have successfully exported.");
            }
        } catch (Exception e) {
            LOG.error(e.getMessage());
            e.printStackTrace();
        }
    }
}
