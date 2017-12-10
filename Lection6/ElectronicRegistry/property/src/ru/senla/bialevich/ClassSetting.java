package ru.senla.bialevich;


import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ClassSetting {
    private static final Logger log = Logger.getLogger(ClassSetting.class);
    private final String PATH_TO_CONFIG = "property\\resources\\config.properties";
    private Properties properties;

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
        properties = new Properties();

        try (FileInputStream stream = new FileInputStream(this.PATH_TO_CONFIG)) {
            properties.load(stream);

        } catch (FileNotFoundException e) {
            log.error("File not Found", e);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

}
