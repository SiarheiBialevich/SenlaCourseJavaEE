package ru.senla.bialevich.api.dao;

import ru.senla.bialevich.entity.BaseEntity;

import java.util.List;

public interface AbstractDao<T extends BaseEntity> {

    void add(T entity);

    List<T> getAll();

    void delete(T entity);
}
