package ru.senla.bialevich.dao;

import org.apache.log4j.Logger;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import ru.senla.bialevich.model.Guest;
import ru.senla.bialevich.model.Room;
import ru.senla.bialevich.model.Service;
import ru.senla.bialevich.enums.RoomStatus;
import ru.senla.bialevich.enums.SortType;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static ru.senla.bialevich.util.parser.ParserResultSet.parseGuest;
import static ru.senla.bialevich.util.parser.ParserResultSet.parseService;

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
