package ru.senla.bialevich.annotations;

import org.apache.log4j.Logger;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AnnotationWorker {
    private static final Logger LOG = Logger.getLogger(AnnotationWorker.class);
    private static final String PATH = "annotation.properties";

    private AnnotationProperty props = new AnnotationProperty();

    public Object configure(Object object) {
        Class<? extends Object> cl = object.getClass();

        Field[] fields = cl.getDeclaredFields();
        for (Field field : fields) {
            boolean isAccessible = field.isAccessible();
            field.setAccessible(true);

            if (field.getAnnotation(ConfigProperty.class) != null) {
                String configName;
                String propertyName;
                Class<?> type;

                try {
                    if (field.getAnnotation(ConfigProperty.class).configName().isEmpty()) {
                        configName = PATH;
                    } else {
                        configName = field.getAnnotation(ConfigProperty.class).configName();
                    }

                    if (field.getAnnotation(ConfigProperty.class).propertyName().isEmpty()) {
                        propertyName = cl.getSimpleName() + "." + field.getName();
                    } else {
                        propertyName = field.getAnnotation(ConfigProperty.class).propertyName();
                    }

                    if (field.getAnnotation(ConfigProperty.class).type().equals(Object.class)) {
                        type = field.getType();
                    } else {
                        type = field.getAnnotation(ConfigProperty.class).type();
                    }

                    String value = props.getProperties(configName, propertyName);

                    field.set(object, getValue(type, value));
                } catch (IllegalArgumentException | IllegalAccessException e) {
                    LOG.error(e.getMessage(), e);
                } finally {
                    field.setAccessible(isAccessible);
                }
            }
        }

        return object;
    }

    private Object getValue(Class<?> type, String value) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        try {
            if (type.equals(Integer.class)) {
                return Integer.parseInt(value);

            } else if (type.equals(Boolean.class)) {
                return Boolean.parseBoolean(value);

            } else if (type.equals(Float.class)) {
                return Float.parseFloat(value);

            } else if (type.equals(Date.class)) {
                return format.parse(value);
            }

        } catch (IllegalArgumentException | ParseException e) {
            e.printStackTrace();
        }

        return value;
    }
}
