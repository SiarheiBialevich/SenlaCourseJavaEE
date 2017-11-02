package ru.senla.bialevich.menuAction.importExportAction.importer;

import org.apache.log4j.Logger;
import ru.senla.bialevich.api.IAction;
import ru.senla.bialevich.menuAction.AbstractAction;
import ru.senla.bialevich.util.Printer;

public class ImportGuests extends AbstractAction implements IAction {
    private static final Logger LOG = Logger.getLogger(ImportGuests.class);
    private Printer printer = new Printer();

    @Override
    public void execute() {
        try {
            hotel.importGuests();
            printer.print("Guests have successfully imported.");
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
    }
}
