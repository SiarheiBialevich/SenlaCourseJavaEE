package ru.senla.bialevich.menuAction.serviceAction;

import org.apache.log4j.Logger;
import ru.senla.bialevich.model.Service;
import ru.senla.bialevich.menuAction.AbstractAction;
import ru.senla.bialevich.request.src.ru.senla.bialevich.DataPackage;
import ru.senla.bialevich.request.src.ru.senla.bialevich.IRequestHandler;
import ru.senla.bialevich.ui.IAction;

import java.util.List;

public class GetAllService extends AbstractAction implements IAction {
    private static final Logger LOG = Logger.getLogger(GetAllService.class);

    @Override
    public void execute(IRequestHandler requestHandler) {

        try {
            DataPackage dataPackage = new DataPackage("getAllService", null);
            List<Service> services = (List<Service>) requestHandler.sendRequest(dataPackage);

            if (services == null) {
                System.out.println("Services not found.");
            } else {
                System.out.println(services);
            }
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
    }
}
