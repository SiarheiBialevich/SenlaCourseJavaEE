package ru.senla.bialevich.dao;

import org.hibernate.Session;
import ru.senla.bialevich.enums.RoomStatus;
import ru.senla.bialevich.enums.ServicesSection;
import ru.senla.bialevich.enums.SortType;
import ru.senla.bialevich.model.BaseEntity;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface AbstractDao<T extends BaseEntity> {

    //read
    List<T> getAll(Session session, SortType type, RoomStatus status) throws SQLException;

    T getById(Session session, Integer id) throws SQLException;

    //create
    void add(Session session,T entity) throws SQLException;

    //update
    void update(Session session, T entity) throws SQLException;

    //delete
    void remove(Session session, T entity) throws SQLException;
}
