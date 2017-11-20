package ru.senla.bialevich.service;

import org.apache.log4j.Logger;

import ru.senla.bialevich.dao.UsedServiceDao;
import ru.senla.bialevich.dao.UsedServiceDaoImpl;
import ru.senla.bialevich.entity.UsedService;
import ru.senla.bialevich.enums.comparator.ServiceSortComparator;
import ru.senla.bialevich.util.CopyAndSortList;

import java.util.List;

public class UsedServiceServiceImpl implements UsedServiceService {
    private static final Logger LOG = Logger.getLogger(UsedServiceServiceImpl.class);
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
        synchronized (serviceDao) {
            currentId = service.getId();
            service.setId(currentId++);
            serviceDao.add(service);
            calcId();
        }
    }

    @Override
    public List<UsedService> getAll() {
        synchronized (serviceDao) {
            List<UsedService> services = null;

            try {
                services = serviceDao.getAll();
            } catch (Exception e) {
                LOG.error(e.getMessage());
            }
            return services;
        }
    }

    @Override
    public UsedService getUsedServiceById(Integer id) {
        synchronized (serviceDao) {
            return serviceDao.getUsedServiceById(id);
        }
    }

    @Override
    public List<UsedService> sortUsedServicesByPrice() {
        synchronized (serviceDao) {
            return copy.getCopiedAndSortedList(serviceDao.getAll(), ServiceSortComparator.SERVICE_PRICE.getServiceComparator());
        }
    }

    @Override
    public List<UsedService> getListUsedServices() {
        synchronized (serviceDao) {
            return serviceDao.getAll();
        }
    }

    @Override
    public void update(UsedService service) {
        synchronized (serviceDao) {
            serviceDao.update(service);
        }
    }

    @Override
    public void setServicesList(List<UsedService> services) {
        synchronized (serviceDao) {
            serviceDao.setServicesList(services);
        }
    }
}
