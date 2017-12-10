package ru.senla.bialevich.dao;

import ru.senla.bialevich.entity.UsedService;

import java.util.List;

public interface UsedServiceDao extends AbstractDao<UsedService> {

    UsedService getUsedServiceById(Integer id);

    void update(UsedService service);

    Integer getServiceIndexById(Integer id);

    void setServicesList(List<UsedService> services);
}
