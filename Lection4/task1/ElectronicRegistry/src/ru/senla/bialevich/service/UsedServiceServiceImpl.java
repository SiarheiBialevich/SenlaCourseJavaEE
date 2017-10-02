package ru.senla.bialevich.service;

import ru.senla.bialevich.api.dao.UsedServiceDao;
import ru.senla.bialevich.api.service.UsedServiceService;
import ru.senla.bialevich.dao.UsedServiceDaoImpl;
import ru.senla.bialevich.entity.UsedService;
import ru.senla.bialevich.util.Printer;
import ru.senla.bialevich.util.comparator.usedServiceComparator.UsedServicePriceComparator;

import java.util.ArrayList;
import java.util.List;

public class UsedServiceServiceImpl implements UsedServiceService {
    private UsedServiceDao serviceDao = new UsedServiceDaoImpl();

    private UsedServicePriceComparator priceComparator = new UsedServicePriceComparator();

    private Printer printer = new Printer();

    private final String MESSAGE1 = "Sorted used services by price";

    @Override
    public void add(UsedService service) {
        serviceDao.add(service);
    }

    @Override
    public void sortUsedServiceByPrice() {
        printer.printMessage(MESSAGE1);

        ArrayList<UsedService> usedServicesSorted = new ArrayList<UsedService>(serviceDao.getAll());
        usedServicesSorted.sort(priceComparator);

        for (UsedService usedService : usedServicesSorted) {
            printer.printObject(usedService);
        }
    }

    @Override
    public List<UsedService> getListUsedServices() {
        return serviceDao.getAll();
    }
}
