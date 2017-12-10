package ru.senla.bialevich.menuAction.importExportAction.exporter;

import org.apache.log4j.Logger;
import ru.senla.bialevich.api.IAction;
import ru.senla.bialevich.menuAction.AbstractAction;
import ru.senla.bialevich.util.Printer;

public class ExportServices extends AbstractAction implements IAction {
    private static final Logger LOG = Logger.getLogger(ExportServices.class);
    private Printer printer = new Printer();

    @Override
    public void execute() {
        try {
            if (hotel.getListUsedServices().size() == 0) {
                printer.print("Services is missing.");
            } else {
                hotel.exportServices();
                printer.print("Services have successfully exported.");
            }
        } catch (Exception e) {
            LOG.error(e.getMessage());
        }
    }
}
