package ru.senla.bialevich.dao;

import org.springframework.stereotype.Repository;
import ru.senla.bialevich.dao.api.ILoacationDao;
import ru.senla.bialevich.entity.Location;

@Repository("locationDaoImpl")
public class LocationDaoImpl extends AbstractDaoImpl<Location> implements ILoacationDao {
}
