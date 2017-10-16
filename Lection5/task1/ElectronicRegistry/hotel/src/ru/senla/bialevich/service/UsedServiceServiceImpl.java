package ru.senla.bialevich.service;

import ru.senla.bialevich.api.dao.UsedServiceDao;
import ru.senla.bialevich.api.service.UsedServiceService;
import ru.senla.bialevich.dao.UsedServiceDaoImpl;
import ru.senla.bialevich.entity.UsedService;
import ru.senla.bialevich.enums.ServiceSortComparator;
import ru.senla.bialevich.util.CopyAndSortList;

import java.util.List;

public class UsedServiceServiceImpl implements UsedServiceService {
    private CopyAndSortList<UsedService> copy = new CopyAndSortList<UsedService>();

    private UsedServiceDao serviceDao = new UsedServiceDaoImpl();


    @Override
    public void add(UsedService service) {
        serviceDao.add(service);
    }

    @Override
    public UsedService getUsedServiceById(Integer id) {
        return serviceDao.getUsedServiceById(id);
    }

    @Override
    public List<UsedService> sortUsedServicesByPrice() {

        return copy.getCopiedAndSortedList(serviceDao.getAll(), ServiceSortComparator.SERVICE_PRICE.getServiceComparator());
    }

    @Override
    public List<UsedService> getListUsedServices() {
        return serviceDao.getAll();
    }
}
