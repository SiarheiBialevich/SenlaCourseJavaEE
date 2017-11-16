package ru.senla.bialevich.menuAction.orderAction;

import org.apache.log4j.Logger;
import ru.senla.bialevich.DataPackage;
import ru.senla.bialevich.IRequestHandler;
import ru.senla.bialevich.api.IAction;

import ru.senla.bialevich.entity.Order;
import ru.senla.bialevich.util.Printer;

import java.util.List;

public class GetOrderList implements IAction {
    private static final Logger log = Logger.getLogger(GetOrderList.class);
    @Override
    public void execute(IRequestHandler requestHandler) {
        Printer printer = new Printer();

        try {
            DataPackage dataPackage = new DataPackage("getAllOrders", null);
            List<Order> orders = (List<Order>) requestHandler.sendRequest(dataPackage);
            if (orders == null) {
                printer.print("Order nit found.");
            } else {
                printer.print(orders);
            }

        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}
