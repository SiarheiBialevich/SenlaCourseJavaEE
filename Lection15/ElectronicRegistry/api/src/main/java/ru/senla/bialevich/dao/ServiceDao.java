package ru.senla.bialevich.dao;

import org.hibernate.Session;
import ru.senla.bialevich.enums.SortType;
import ru.senla.bialevich.model.Guest;
import ru.senla.bialevich.model.Service;
import ru.senla.bialevich.enums.ServicesSection;

import java.sql.Connection;
import java.util.List;

public interface ServiceDao extends AbstractDao<Service> {

    List<Double> getPriceBySection(Session session, ServicesSection section);

    List<Service> getServices(Session session, Guest guest, SortType type);
}
