package ru.senla.bialevich.connectordb;

import org.apache.log4j.Logger;
import ru.senla.bialevich.ClassSetting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectorDb {
    private static final Logger LOG = Logger.getLogger(ConnectorDb.class);

    private static ConnectorDb instance;
    private Connection con;

    private static String HOST = ClassSetting.getProps().getHostToDb();
    private static String DRIVER = ClassSetting.getProps().getPathToDriverJdbc();
    private static String LOGIN = ClassSetting.getProps().getLoginToDb();
    private static String PASS = ClassSetting.getProps().getPasswordToDb();

    private ConnectorDb() {
        createConnection();
    }

    private void createConnection() {

        try {
            Class.forName(DRIVER);
            con = DriverManager.getConnection(HOST, LOGIN, PASS);
            LOG.info("Connection SUCCESSFUL");
        } catch (ClassNotFoundException | SQLException e) {
            LOG.error("Failed to connect to the database.", e);
        }
    }

    public Connection getConnection() {
        if (con == null) {
            createConnection();
        }

        return con;
    }

    public void closeConnection() {
        try {
            if (con != null) {
                con.close();

                LOG.info("Connection CLOSE");
            }
        } catch (SQLException e) {
            LOG.error("Connection is not closed", e);
        }
    }

    public void closeStatement(Statement statement) {
        try {
            statement.close();
        } catch (SQLException e) {
            LOG.error(e.getMessage());
        }
    }

    public static ConnectorDb getInstance() {
        if (instance == null) {
            instance = new ConnectorDb();
        }

        return instance;
    }
}
