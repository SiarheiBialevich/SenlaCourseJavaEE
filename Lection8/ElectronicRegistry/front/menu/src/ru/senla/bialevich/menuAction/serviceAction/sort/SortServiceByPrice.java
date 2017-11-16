package ru.senla.bialevich.menuAction.serviceAction.sort;

import ru.senla.bialevich.IRequestHandler;
import ru.senla.bialevich.api.IAction;
import ru.senla.bialevich.menuAction.AbstractAction;
import ru.senla.bialevich.util.Printer;

public class SortServiceByPrice extends AbstractAction implements IAction {

    @Override
    public void execute(IRequestHandler requestHandler) {
        Printer printer = new Printer();

        printer.print(hotel.sortUsedServicesByPrice());
    }
}
