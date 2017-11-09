package ru.senla.bialevich.dao;

import ru.senla.bialevich.api.dao.UsedServiceDao;
import ru.senla.bialevich.entity.UsedService;

import java.util.List;

public class UsedServiceDaoImpl extends AbstractDaoImpl<UsedService> implements UsedServiceDao {

    private List<UsedService> serviceModel;

    public UsedServiceDaoImpl() {
        super(UsedService.class);
    }

    public UsedServiceDaoImpl(List<UsedService> services) {
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

    @Override
    public void update(UsedService service) {
        getTargetList().set(getServiceIndexById(service.getId()), service);
    }

    @Override
    public Integer getServiceIndexById(Integer id) {
        for (int i = 0; i < getTargetList().size(); i++) {
            if (getTargetList().get(i).getId() == id) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public void setServicesList(List<UsedService> services) {
        dataBase.setUsedServiceList(services);
    }
}
