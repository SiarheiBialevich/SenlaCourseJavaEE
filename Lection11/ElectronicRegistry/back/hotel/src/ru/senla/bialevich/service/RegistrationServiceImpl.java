package ru.senla.bialevich.service;

import org.apache.log4j.Logger;
import ru.senla.bialevich.dao.RegistrationDao;
import ru.senla.bialevich.dao.RegistrationDaoImpl;
import ru.senla.bialevich.entity.Registration;
import ru.senla.bialevich.enums.entity.SortType;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class RegistrationServiceImpl extends AbstractService implements RegistrationService {

    private static final Logger LOG = Logger.getLogger(RegistrationServiceImpl.class);

    private RegistrationDao registrationDao;

    public RegistrationServiceImpl() {
    }

    @Override
    public void addRecord(Registration registration) {
        try {
            registrationDao.add(registration, connection);
        } catch (Exception e) {
            LOG.error(e.getMessage());
        }

    }

    @Override
    public void update(Registration registration) {
        boolean status = false;

        try {
            connection.setAutoCommit(false);
            status = registrationDao.update(registration, connection);
            if (status) {
                connection.commit();
            }
        } catch (Exception e) {
            try {
                connection.rollback();
            } catch (SQLException e1) {
                LOG.error(e1.getMessage(), e1);
            }
            LOG.error(e.getMessage());
        }
    }

    @Override
    public Registration getRegistration(Integer id) {
        Registration registration = null;
        try {
            registration = registrationDao.getById(id, connection);
        } catch (Exception e) {
            LOG.error(e.getMessage());
        }
        return registration;
    }

    @Override
    public List<Registration> getAll(SortType type) {
        List<Registration> registrations = null;
        try {
            registrations = registrationDao.getAll(type, null, connection);
        } catch (Exception e) {
            LOG.error(e.getMessage());
        }
        return registrations;
    }

    public void setRegistrationRepository(RegistrationDao registrationDao) {
        this.registrationDao = registrationDao;
    }
}
