package ru.senla.bialevich.dao;

import org.springframework.stereotype.Repository;
import ru.senla.bialevich.dao.api.IBindingDao;
import ru.senla.bialevich.entity.Binding;

@Repository("bindingDaoImpl")
public class BindingDaoImpl extends AbstractDaoImpl<Binding> implements IBindingDao {
}
