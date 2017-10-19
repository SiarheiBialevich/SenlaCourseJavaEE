package ru.senla.bialevich.dao;

import ru.senla.bialevich.api.dao.AbstractDao;
import ru.senla.bialevich.database.DataBase;
import ru.senla.bialevich.entity.BaseEntity;
import ru.senla.bialevich.enums.entity.RoomStatus;

import java.util.List;

public abstract class AbstractDaoImpl<T extends BaseEntity> implements AbstractDao<T> {

    protected DataBase dataBase = DataBase.getDataBase();

    private Class<T> clazz;

    protected AbstractDaoImpl(Class<T> clazz) {
        this.clazz = clazz;
    }

    abstract List<T> getTargetList();

    @Override
    public void add(T entity) {
        getTargetList().add(entity);
    }

    @Override
    public List<T> getAll() {

        return getTargetList();
    }

    @Override
    public void delete(T entity) {
        getTargetList().remove(entity);
    }
}
