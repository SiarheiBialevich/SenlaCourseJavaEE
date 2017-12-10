package ru.senla.bialevich.test;

import ru.senla.bialevich.connectordb.ConnectorDb;

public class Run {
    public static void main(String[] args) {
        ConnectorDb.getInstance().getConnection();

        ConnectorDb.getInstance().closeConnection();
    }
}
