package ru.senla.bialevich.service;

import ru.senla.bialevich.connectordb.ConnectorDb;

import java.sql.Connection;

public abstract class AbstractService {

    Connection connection = ConnectorDb.getInstance().getConnection();
}
