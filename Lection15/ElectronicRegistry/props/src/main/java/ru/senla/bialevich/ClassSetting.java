package ru.senla.bialevich;


import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ClassSetting {
    private static final Logger log = Logger.getLogger(ClassSetting.class);

//    private static final String PATH_TO_CONFIG = "props\\src\\main\\resources\\config.properties";
    private static final String PATH_TO_CONFIG = "f:\\WebServer\\webapps\\ROOT\\WEB-INF\\classes\\config.properties";

    private static final String BLOCK_STATUS = "block.status";
    private static final String COUNT_RECORDS = "count.records";
    private static final String PATH_TO_ENTITY_FILE = "path.to.entity.file";
    private static final String MAIN_FILE = "main.file";
    private static final String PATH_TO_INSTANCE = "path.to.instance";

    private static final String DRIVER = "db.driver";
    private static final String HOST = "db.host";
    private static final String LOGIN = "db.login";
    private static final String PASSWORD = "db.password";

    private static Props props;

    public static Props getProps() {
        if (props == null) {
            Properties properties = new Properties();

            try (FileInputStream stream = new FileInputStream(PATH_TO_CONFIG)) {
                props = new Props();

                properties.load(stream);

                props.setBlockStatus(Boolean.parseBoolean(properties.getProperty(BLOCK_STATUS)));
                props.setCountRegistrations(Integer.parseInt(properties.getProperty(COUNT_RECORDS)));
                props.setPathToFileEntity(properties.getProperty(PATH_TO_ENTITY_FILE));
                props.setPathToMainFile(properties.getProperty(MAIN_FILE));
                props.setPathToInstanceFile(properties.getProperty(PATH_TO_INSTANCE));

                props.setHostToDb(properties.getProperty(HOST));
                props.setPathToDriverJdbc(properties.getProperty(DRIVER));
                props.setLoginToDb(properties.getProperty(LOGIN));
                props.setPasswordToDb(properties.getProperty(PASSWORD));

            } catch (FileNotFoundException e) {
                log.error("File not Found", e);
            } catch (IOException e) {
                log.error(e.getMessage(), e);
            }
        }

        return props;
    }
}
