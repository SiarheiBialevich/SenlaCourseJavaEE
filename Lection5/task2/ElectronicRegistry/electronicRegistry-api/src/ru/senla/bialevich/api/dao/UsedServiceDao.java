package ru.senla.bialevich.api.dao;

import ru.senla.bialevich.entity.UsedService;

public interface UsedServiceDao extends AbstractDao<UsedService> {

    UsedService getUsedServiceById(Integer id);
}
