package ru.senla.bialevich.service;

import org.apache.log4j.Logger;
import ru.senla.bialevich.dao.ServiceDao;
import ru.senla.bialevich.dependency.DependencyInjection;
import ru.senla.bialevich.enums.ServicesSection;
import ru.senla.bialevich.enums.SortType;
import ru.senla.bialevich.model.Guest;
import ru.senla.bialevich.model.Service;

import java.util.List;

public class ServiceServiceImpl extends AbstractService implements ServiceService {

    private static final Logger LOG = Logger.getLogger(ServiceServiceImpl.class);

    private ServiceDao serviceDao = (ServiceDao) DependencyInjection.getInjection().getInstance(ServiceDao.class);

    public ServiceServiceImpl() {
    }

    @SuppressWarnings("Duplicates")
    @Override
    public void addService(Service service) {
        try {
            serviceDao.add(session, service);
        } catch (Exception e) {
            LOG.error(e.getMessage());
        }
    }

    @Override
    public void addServiceToGuest(Guest guest, Service service) {
        try {
            service.setGuest(guest);
            serviceDao.update(session, service);
        }catch (Exception e) {
            LOG.error(e.getMessage());
        }
    }

    @Override
    public void removeServiceOfGuest(Guest guest, Service service) {
        try {
            service.setGuest(null);
            serviceDao.update(session, service);
        }catch (Exception e) {
            LOG.error(e.getMessage());
        }
    }

    @SuppressWarnings("Duplicates")
    @Override
    public Service getService(int id) {
        Service service = null;
        try {
            service = serviceDao.getById(session, id);
        } catch (Exception e) {
            LOG.error(e.getMessage());
        }

        return service;
    }

    @SuppressWarnings("Duplicates")
    @Override
    public void update(Service service) {
        try {
            session.beginTransaction();
            serviceDao.update(session, service);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            LOG.error(e.getMessage());
        }
    }

    @SuppressWarnings("Duplicates")
    @Override
    public void delete(Service service) {
        try {
            serviceDao.remove(session, service);
        } catch (Exception e) {
            LOG.error(e.getMessage());
        }
    }

    @Override
    public List<Service> getServices(Guest guest, SortType type) {
        List<Service> services = null;
        try {
            services = serviceDao.getServices(session, guest, type);
        } catch (Exception e) {
            LOG.error(e.getMessage());
        }
        return services;
    }

    @SuppressWarnings("Duplicates")
    @Override
    public List<Service> getAll(SortType type) {
        List<Service> services = null;
        try {
            session.beginTransaction();
            services = serviceDao.getAll(session, type, null);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            LOG.error(e.getMessage());
        }
        return services;
    }

    @SuppressWarnings("Duplicates")
    @Override
    public List<Double> getPricesBySection(ServicesSection section) {
        List<Double> prices = null;
        try {
            session.beginTransaction();
            prices = serviceDao.getPriceBySection(session, section);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            LOG.error(e.getMessage());
        }
        return prices;
    }
}
