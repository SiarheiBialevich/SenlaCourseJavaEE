package ru.senla.bialevich.dao;

import ru.senla.bialevich.entity.BaseEntity;
import ru.senla.bialevich.enums.entity.RoomStatus;
import ru.senla.bialevich.enums.entity.SortType;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface AbstractDao<T extends BaseEntity> {

    //read
    List<T> getAll(SortType type, RoomStatus status, Connection connection) throws SQLException;

    T getById(Integer id, Connection connection) throws SQLException;

    //create
    void add(T entity, Connection connection) throws SQLException;

    //update
    Boolean update(T entity, Connection connection) throws SQLException;

    //delete
    void remove(T entity, Connection connection) throws SQLException;
}
