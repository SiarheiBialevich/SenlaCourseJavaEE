package ru.senla.bialevich.dao;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import ru.senla.bialevich.model.Guest;

public class GuestDaoImpl extends AbstractDaoImpl<Guest> implements GuestDao {

    private final static Logger LOG = Logger.getLogger(GuestDaoImpl.class);

    public GuestDaoImpl() {
        super(Guest.class);
    }

    @Override
    public Integer getCount(Session session) {

        int count = 0;

        Criteria criteria = session.createCriteria(Guest.class);

        count = ((Long) criteria
                .setProjection(Projections.rowCount())
                .uniqueResult()).intValue();

        return count;
    }

}
