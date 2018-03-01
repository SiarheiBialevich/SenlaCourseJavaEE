package ru.senla.bialevich.dao;

import org.springframework.stereotype.Repository;
import ru.senla.bialevich.dao.api.ICityDao;
import ru.senla.bialevich.entity.City;

@Repository("cityDaoImpl")
public class CityDaoImpl extends AbstractDaoImpl<City> implements ICityDao {
}
