package ru.senla.bialevich.menuAction.serviceAction.sort;

import ru.senla.bialevich.api.IAction;
import ru.senla.bialevich.api.controller.ControllerHotel;
import ru.senla.bialevich.controller.ControllerHotelImpl;
import ru.senla.bialevich.util.Printer;

public class SortServiceByPrice implements IAction {

    @Override
    public void execute() {
        ControllerHotel hotel = new ControllerHotelImpl();
        Printer printer = new Printer();

        printer.print(hotel.sortUsedServicesByPrice());
    }
}
