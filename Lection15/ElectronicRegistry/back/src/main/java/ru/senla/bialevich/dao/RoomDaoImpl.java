package ru.senla.bialevich.dao;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import ru.senla.bialevich.enums.RoomSection;
import ru.senla.bialevich.enums.RoomStatus;
import ru.senla.bialevich.model.Registration;
import ru.senla.bialevich.model.Room;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RoomDaoImpl extends AbstractDaoImpl<Room> implements RoomDao {

    private final static Logger LOG = Logger.getLogger(RoomDaoImpl.class);

    public RoomDaoImpl() {
        super(Room.class);
    }


    @Override
    public Integer getCountFreeRooms(Session session) {
        int count = 0;
        Criteria criteria = session.createCriteria(Room.class);
        try {
            count = ((Long) criteria
                    .add(Restrictions.eq("status", RoomStatus.FREE))
                    .setProjection(Projections.rowCount())
                    .uniqueResult()).intValue();
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
        return count;
    }

    @Override
    public List<Room> getLatestGuests(Session session, Integer count) {
        List<Room> rooms = new ArrayList<>();
        try {
            DetachedCriteria ownerCriteria = DetachedCriteria.forClass(Registration.class);
            ownerCriteria.setProjection(Projections.property("roomId"));

            Criteria criteria = session.createCriteria(Room.class);
            criteria.add(Property.forName("id").in(ownerCriteria));

            Criteria rowsRoom = session.createCriteria(Registration.class);
            rowsRoom.setProjection(Projections.property("roomId"));
            int max = ((Long) rowsRoom.setProjection(Projections.rowCount()).uniqueResult()).intValue();

            rooms = criteria.setFirstResult(max - count).setMaxResults(count).list();
        } catch (Exception e) {
            LOG.error(e.getMessage());
        }
        return rooms;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Room> getReleasedInFuture(Session session, Date date) {
        List<Room> rooms = new ArrayList<>();
        try {
            rooms = session.createQuery("SELECT r FROM Room r, Registration reg WHERE reg.roomId = r.id AND reg.finalDate <:currentDate")
                    .setParameter("currentDate", date)
                    .list();

        } catch (Exception e) {
            LOG.error(e.getMessage());
        }
        return rooms;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Double> getPriceBySection(Session session, RoomSection section) {
        List<Double> prices = new ArrayList<>();
        try {
            Criteria criteria = session.createCriteria(Room.class);
            prices = criteria.setProjection(Projections.groupProperty("price"))
                    .add(Restrictions.eq("section", section))
                    .list();
        } catch (Exception e) {
            LOG.error(e.getMessage());
        }
        return prices;
    }
}
