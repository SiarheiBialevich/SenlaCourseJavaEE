package ru.senla.bialevich.service;

import ru.senla.bialevich.api.dao.UsedServiceDao;
import ru.senla.bialevich.api.service.UsedServiceService;
import ru.senla.bialevich.dao.UsedServiceDaoImpl;
import ru.senla.bialevich.entity.UsedService;
import ru.senla.bialevich.enums.ServiceConstEnum;
import ru.senla.bialevich.util.CopyAndSortList;
import ru.senla.bialevich.util.Printer;
import ru.senla.bialevich.util.comparator.usedServiceComparator.UsedServicePriceComparator;

import java.util.List;

public class UsedServiceServiceImpl implements UsedServiceService {
    private static final UsedServicePriceComparator PRICE_COMPARATOR = new UsedServicePriceComparator();

    private CopyAndSortList<UsedService> copy = new CopyAndSortList<UsedService>();

    private UsedServiceDao serviceDao = new UsedServiceDaoImpl();

    private Printer printer = new Printer();

    @Override
    public void add(UsedService service) {
        serviceDao.add(service);
    }

    @Override
    public UsedService getUsedServiceById(Integer id) {
        return serviceDao.getUsedServiceById(id);
    }

    @Override
    public void sortUsedServicesByPrice() {
        printer.print(ServiceConstEnum.SORTED_SERVICE_BY_PRICE.getDescription());
        printer.print(copy.getCopiedAndSortedList(serviceDao.getAll(), PRICE_COMPARATOR));
    }

    @Override
    public List<UsedService> getListUsedServices() {
        return serviceDao.getAll();
    }
}
