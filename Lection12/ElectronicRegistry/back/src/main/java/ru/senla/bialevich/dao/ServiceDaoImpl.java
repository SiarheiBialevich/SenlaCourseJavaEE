package ru.senla.bialevich.dao;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import ru.senla.bialevich.model.Guest;
import ru.senla.bialevich.model.Service;
import ru.senla.bialevich.enums.RoomStatus;
import ru.senla.bialevich.enums.ServicesSection;
import ru.senla.bialevich.enums.SortType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import static ru.senla.bialevich.util.parser.ParserResultSet.parseService;

public class ServiceDaoImpl extends AbstractDaoImpl<Service> implements ServiceDao {

    private final static Logger LOG = Logger.getLogger(RoomDaoImpl.class);

    public ServiceDaoImpl() {
        super(Service.class);
    }


    @SuppressWarnings("unchecked")
    @Override
    public List<Double> getPriceBySection(Session session, ServicesSection section) {
        List<Double> prices = new ArrayList<>();
        try {
            Criteria criteria = session.createCriteria(Service.class);
            prices = criteria.setProjection(Projections.groupProperty("price"))
                    .add(Restrictions.eq("section", section))
                    .list();
        } catch (Exception e) {
            LOG.error(e.getMessage());
        }
        return prices;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Service> getServices(Session session, Guest guest, SortType type) {
        List<Service> services = new ArrayList<>();
        try {
            Criteria criteria = session.createCriteria(Service.class);
            services = criteria.add(Restrictions.eq("guestId", guest.getId()))
                    .addOrder(Order.asc(type.toString())).list();
        } catch (Exception e) {
            LOG.error(e.getMessage());
        }

        return services;
    }
}
