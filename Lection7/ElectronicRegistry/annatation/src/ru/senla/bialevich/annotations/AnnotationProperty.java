package ru.senla.bialevich.annotations;

import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class AnnotationProperty {
    private static final Logger LOG = Logger.getLogger(AnnotationProperty.class);
    private Map<String, Properties> propertiesMap = new HashMap<>();

    public Object getProperties(String path, String key) {
        if (!propertiesMap.containsKey(path)) {
            Properties properties = new Properties();
            try (FileInputStream fis = new FileInputStream(path)){
                properties.load(fis);
            } catch (IOException e) {
                LOG.error(e.getMessage(), e);
            }

            propertiesMap.put(path, properties);
        }

        Object properties = propertiesMap.get(path).getProperty(key);
        if (properties == null) {
            LOG.error("File not found");
        }

        return properties;
    }
}
