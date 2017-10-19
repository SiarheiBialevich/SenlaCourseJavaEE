package ru.senla.bialevich;


import org.apache.log4j.Logger;
import ru.senla.bialevich.util.Printer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ClassSetting {
    private static final Logger log = Logger.getLogger(ClassSetting.class);
    private final String PATH_TO_CONFIG = "config.properties";
    private Map<String, String> propsHolder = null;

    private Printer printer = new Printer();

    public ClassSetting() {
        this.propsHolder = new HashMap<>();
        this.init();
    }

    private void init() {
        Properties properties = new Properties();

        try (FileInputStream stream = new FileInputStream(this.PATH_TO_CONFIG)) {
            properties.load(stream);

            for (Object object : properties.keySet()) {
                String key = String.valueOf(object);
                this.propsHolder.put(key, properties.getProperty(key));
            }
        } catch (FileNotFoundException e) {
            log.error("File not Found", e);
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }

    public Map<String, String> getPropsHolder() {
        return propsHolder;
    }

    public void setPropsHolder(Map<String, String> propsHolder) {
        this.propsHolder = propsHolder;
    }
}
