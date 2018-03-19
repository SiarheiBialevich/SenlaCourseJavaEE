package ru.senla.bialevich.dao;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import ru.senla.bialevich.model.Guest;
import ru.senla.bialevich.model.Registration;
import ru.senla.bialevich.enums.RoomStatus;
import ru.senla.bialevich.enums.SortType;
import ru.senla.bialevich.model.Room;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import static ru.senla.bialevich.util.parser.ParserResultSet.parseRegistration;

public class RegistrationDaoImpl extends AbstractDaoImpl<Registration> implements RegistrationDao {

    private final static Logger LOG = Logger.getLogger(RegistrationDaoImpl.class);

    public RegistrationDaoImpl() {
        super(Registration.class);
    }


    @Override
    public List<Guest> getSortedByFinalDate(Session session) {

        List<Guest> guests = new ArrayList<>();
        try {
            guests = session.createQuery("SELECT g FROM Guest g INNER JOIN Registration reg ON reg.guestId = g.id ORDER BY reg.finalDate")
                    .list();
        }catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
        return guests;
    }

    @SuppressWarnings("unchecked")
    @Override
    public double getSumByRoom(Session session, Room room, Guest guest) {
        double sum = 0;
        try {
            Criteria criteria = session.createCriteria(Registration.class);
            Criterion guestId = Restrictions.eq("guestId", guest.getId());
            Criterion roomId = Restrictions.eq("roomId", room.getId());
            List<Registration> registrations = criteria.add(Restrictions.and(guestId, roomId)).list();
            int finalDate = registrations.get(0).getFinalDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().getDayOfYear();
            int startDate = registrations.get(0).getStartDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().getDayOfYear();
            sum = (finalDate - startDate) * room.getPrice();
        } catch (Exception e) {
            LOG.error(e.getMessage());
        }
        return sum;
    }
}
