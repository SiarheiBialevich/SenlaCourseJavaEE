package ru.senla.bialevich.dao;

import org.springframework.stereotype.Repository;
import ru.senla.bialevich.dao.api.IDiliveryDao;
import ru.senla.bialevich.entity.Dilivery;

@Repository("diliveryDaoImpl")
public class DiliveryDaoImpl extends AbstractDaoImpl<Dilivery> implements IDiliveryDao {
}
