package ru.senla.bialevich.service;

import ru.senla.bialevich.api.dao.UsedServiceDao;
import ru.senla.bialevich.api.service.UsedServiceService;
import ru.senla.bialevich.dao.UsedServiceDaoImpl;
import ru.senla.bialevich.entity.UsedService;
import ru.senla.bialevich.enums.comparator.ServiceSortComparator;
import ru.senla.bialevich.util.CopyAndSortList;

import java.util.List;

public class UsedServiceServiceImpl implements UsedServiceService {
    private CopyAndSortList<UsedService> copy = new CopyAndSortList<UsedService>();

    private UsedServiceDao serviceDao = new UsedServiceDaoImpl();

    private Integer currentId = 1;

    private void calcId() {
        Integer maxId = 0;
        for (UsedService service :serviceDao.getAll()) {
            if (service.getId() > maxId) {
                maxId = service.getId();
            }
        }
        currentId = maxId + 1;
    }

    @Override
    public void add(UsedService service) {
        service.setId(currentId++);
        serviceDao.add(service);
        calcId();
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
