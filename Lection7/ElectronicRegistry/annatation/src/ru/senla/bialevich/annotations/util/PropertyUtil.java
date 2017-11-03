package ru.senla.bialevich.annotations.util;

import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


public class PropertyUtil {
    private static final Logger LOG = Logger.getLogger(PropertyUtil.class);
    private Map<String, Properties> propertiesMap = new HashMap<String, Properties>();

    public String getProperties(String path, String key) {
        String result = null;
        try {

            if (propertiesMap.get(path) == null) {
                Properties properties = new Properties();
                properties.load(new FileInputStream(new File(path)));
                propertiesMap.put(path, properties);
                result = propertiesMap.get(path).getProperty(key);
            } else {
                result = propertiesMap.get(path).getProperty(key);
            }

        } catch (IOException e) {
            LOG.error(e.getMessage(), e);
        }

        return result;
    }
}
