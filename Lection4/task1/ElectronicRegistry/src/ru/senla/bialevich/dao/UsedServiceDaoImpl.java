package ru.senla.bialevich.dao;

import ru.senla.bialevich.api.dao.UsedServiceDao;
import ru.senla.bialevich.entity.UsedService;

import java.util.List;

public class UsedServiceDaoImpl extends AbstractDaoImpl<UsedService> implements UsedServiceDao {

    public UsedServiceDaoImpl() {
        super(UsedService.class);
    }

    @Override
    List<UsedService> getTargetList() {
        return dataBase.getUsedServiceList();
    }
}
