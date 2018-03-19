package ru.senla.bialevich;


import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ClassSetting {
    private static final Logger log = Logger.getLogger(ClassSetting.class);
    private static final String BLOCK_STATUS = "block.status";
    private static final String COUNT_REGISTRATIONS = "count.registrations";
    private static final String PATH_TO_ENTITY_FILE = "path.to.entity.file";
    private static final String MAIN_FILE = "main.file";
    private static final String PATH_TO_INSTANCE = "path.to.instance";
    private final String PATH_TO_CONFIG = "property\\resources\\config.properties";

    private static Properties properties;
    private static Props props;

    private static ClassSetting setting;

    public static ClassSetting getInstance() {
        if (setting == null) {
            setting = new ClassSetting();
        }

        return setting;
    }

    public ClassSetting() {

        this.init();
    }

    private void init() {
        if (props == null) {
            properties = new Properties();

            try (FileInputStream stream = new FileInputStream(PATH_TO_CONFIG)) {
                props = new Props();
                properties.load(stream);

                props.setBlockStatus(Boolean.parseBoolean(properties.getProperty(BLOCK_STATUS)));
                props.setCountRegistrations(Integer.parseInt(properties.getProperty(COUNT_REGISTRATIONS)));
                props.setPathToFileEntity(properties.getProperty(PATH_TO_ENTITY_FILE));
                props.setPathToMainFile(properties.getProperty(MAIN_FILE));
                props.setPathToInstanceFile(properties.getProperty(PATH_TO_INSTANCE));

            } catch (FileNotFoundException e) {
                log.error("File not Found", e);
            } catch (IOException e) {
                log.error(e.getMessage(), e);
            }
        }

    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    public static Props getProps() {
        return props;
    }
}
