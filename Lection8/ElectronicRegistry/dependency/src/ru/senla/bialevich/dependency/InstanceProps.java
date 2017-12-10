package ru.senla.bialevich.dependency;

import ru.senla.bialevich.ClassSetting;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class InstanceProps {
    private static InstanceProps props;

    private Properties properties = new Properties();

    public static InstanceProps getInstance() {
        if (props == null) {
            props = new InstanceProps();
        }
        return props;
    }

    public InstanceProps() {
        try (FileInputStream stream = new FileInputStream(ClassSetting.getProps().getPathToInstanceFile())) {
            properties.load(stream);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getRealization(String className) {
        return properties.getProperty(className);
    }
}
