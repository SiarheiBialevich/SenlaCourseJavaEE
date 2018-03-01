package ru.senla.bialevich.dao;

import org.springframework.stereotype.Repository;
import ru.senla.bialevich.dao.api.IAddressDao;
import ru.senla.bialevich.entity.Address;

@Repository("addressDaoImpl")
public class AddressDaoImpl extends AbstractDaoImpl<Address> implements IAddressDao {
}
