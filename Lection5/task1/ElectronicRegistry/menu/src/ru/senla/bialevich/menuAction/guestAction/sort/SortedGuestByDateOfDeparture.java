package ru.senla.bialevich.menuAction.guestAction.sort;

import ru.senla.bialevich.api.IAction;
import ru.senla.bialevich.controller.ControllerHotelImpl;
import ru.senla.bialevich.util.Printer;

public class SortedGuestByDateOfDeparture implements IAction {

    @Override
    public void execute() {
        Printer printer = new Printer();

        printer.print(ControllerHotelImpl.getInstance().sortedGuestsByDateOfDeparture());
    }
}