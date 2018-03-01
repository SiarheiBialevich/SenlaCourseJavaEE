package ru.senla.bialevich.dao.api;

import ru.senla.bialevich.entity.BaseEntity;

import java.sql.SQLException;
import java.util.List;

public interface IAbstractDao<T extends BaseEntity> {

    //read
    List<T> getAll();

    T getById(Integer id) throws SQLException;

    //create
    void add(T entity) throws SQLException;

    //update
    void update(T entity) throws SQLException;

    //delete
    void delete(T entity) throws SQLException;
}
