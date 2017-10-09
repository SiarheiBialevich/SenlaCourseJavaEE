package ru.senla.bialevich.dao;

import ru.senla.bialevich.api.dao.UsedServiceDao;
import ru.senla.bialevich.entity.UsedService;

import java.util.List;

public class UsedServiceDaoImpl extends AbstractDaoImpl<UsedService> implements UsedServiceDao {

    public UsedServiceDaoImpl() {
        super(UsedService.class);
    }

    @Override
    public UsedService getUsedServiceById(Integer id) {
        UsedService usedService = null;
        for (int i = 0; i < getTargetList().size(); i++) {
            if (getTargetList().get(i).getId().equals(id)) {
                usedService = getTargetList().get(i);
            }
        }

        return usedService;
    }

    @Override
    List<UsedService> getTargetList() {
        return dataBase.getUsedServiceList();
    }
}
