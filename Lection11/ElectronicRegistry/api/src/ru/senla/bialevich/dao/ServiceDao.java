package ru.senla.bialevich.dao;

import ru.senla.bialevich.entity.Service;
import ru.senla.bialevich.enums.entity.ServicesSection;

import java.sql.Connection;
import java.util.List;

public interface ServiceDao extends AbstractDao<Service> {

    List<Double> getPriceBySection(ServicesSection section, Connection connection);
}
