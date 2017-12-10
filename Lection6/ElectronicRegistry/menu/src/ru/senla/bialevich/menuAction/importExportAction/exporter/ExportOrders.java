package ru.senla.bialevich.menuAction.importExportAction.exporter;

import org.apache.log4j.Logger;
import ru.senla.bialevich.api.IAction;
import ru.senla.bialevich.menuAction.AbstractAction;
import ru.senla.bialevich.util.Printer;

public class ExportOrders extends AbstractAction implements IAction {
    private static final Logger LOG = Logger.getLogger(ExportOrders.class);
    private Printer printer = new Printer();

    @Override
    public void execute() {
        try {
            if (hotel.getListOrders().size() == 0) {
                printer.print("Orders is missing.");
            } else {
                hotel.exportOrders();
                printer.print("Orders have successfully exported.");
            }
        } catch (Exception e) {
            LOG.error(e.getMessage());
        }
    }
}
