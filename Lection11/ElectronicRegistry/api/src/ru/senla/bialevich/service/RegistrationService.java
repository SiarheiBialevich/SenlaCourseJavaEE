package ru.senla.bialevich.service;

import ru.senla.bialevich.dao.RegistrationDao;
import ru.senla.bialevich.entity.Registration;
import ru.senla.bialevich.enums.entity.SortType;

import java.util.List;

public interface RegistrationService {

    void addRecord(Registration registration);

    void update(Registration registration);

    Registration getRegistration(Integer id);

    List<Registration> getAll(SortType type);

    void setRegistrationRepository(RegistrationDao registrationRepository);
}
