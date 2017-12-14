package ru.senla.bialevich.service;

import org.apache.log4j.Logger;
import ru.senla.bialevich.dao.ServiceDao;
import ru.senla.bialevich.dependency.DependencyInjection;
import ru.senla.bialevich.entity.Service;
import ru.senla.bialevich.enums.entity.ServicesSection;
import ru.senla.bialevich.enums.entity.SortType;

import java.sql.SQLException;
import java.util.List;

public class ServiceServiceImpl extends AbstractService implements ServiceService {

    private static final Logger LOG = Logger.getLogger(ServiceServiceImpl.class);

    private ServiceDao serviceDao = (ServiceDao) DependencyInjection.getInjection().getInstance(ServiceDao.class);

    public ServiceServiceImpl() {
    }

    @Override
    public void addService(Service service) {
        try {
            serviceDao.add(service, connection);
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
    }

    @Override
    public Service getService(Integer id) {
        Service service = null;
        try {
            service = serviceDao.getById(id, connection);
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
        return service;
    }

    @Override
    public void update(Service service) {
        boolean status = false;
        try {
            connection.setAutoCommit(false);
            status = serviceDao.update(service, connection);
            if (status) {
                connection.commit();
            }
        } catch (Exception e) {
            try {
                connection.rollback();
            } catch (SQLException sql) {
                LOG.error(sql.getMessage());
            }
            LOG.error(e.getMessage(), e);
        }
    }

    @Override
    public void delete(Service service) {
        try {
            serviceDao.remove(service, connection);
        } catch (Exception e) {
            LOG.error(e.getMessage());
        }
    }

    @Override
    public List<Service> getAll(SortType type) {
        List<Service> services = null;
        try {
            services = serviceDao.getAll(type, null, connection);
        } catch (Exception e) {
            LOG.error(e.getMessage());
        }
        return services;
    }

    @Override
    public List<Double> getPricesBySection(ServicesSection section) {
        List<Double> prices = null;
        try {
            prices = serviceDao.getPriceBySection(section, connection);
        } catch (Exception e) {
            LOG.error(e.getMessage());
        }
        return prices;
    }

    public void setServiceDao(ServiceDao serviceDao) {
        this.serviceDao = serviceDao;
    }
}
