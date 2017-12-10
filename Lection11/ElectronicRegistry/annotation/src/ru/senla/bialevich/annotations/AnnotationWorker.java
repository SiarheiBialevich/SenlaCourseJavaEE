package ru.senla.bialevich.annotations;

import org.apache.log4j.Logger;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AnnotationWorker {
    private static final Logger LOG = Logger.getLogger(AnnotationWorker.class);
    private static final String PATH = "annotation.properties";
    private static AnnotationWorker instance;

    private AnnotationProperty props;

    private AnnotationWorker() {
        props = new AnnotationProperty();
    }

    public static AnnotationWorker getInstance() {
        if (instance==null) {
            instance = new AnnotationWorker();
        }

        return instance;
    }

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

                ConfigProperty property = field.getAnnotation(ConfigProperty.class);
                try {
                    if (property.configName().equals("")) {
                        configName = PATH;
                    } else {
                        configName = property.configName();
                    }

                    if (property.propertyName().equals("")) {
                        propertyName = cl.getSimpleName() + "." + field.getName();
                    } else {
                        propertyName = property.propertyName();
                    }

                    if (property.type().equals(Object.class)) {
                        type = String.class;
                    } else {
                        type = property.type();
                    }

                    Object nValue = getValue(configName, propertyName, type);

                    field.set(object, nValue);
                } catch (IllegalArgumentException | IllegalAccessException e) {
                    LOG.error(e.getMessage(), e);
                } finally {
                    field.setAccessible(false);
                    field.setAccessible(isAccessible);
                }
            }
        }

        return object;
    }

    private Object getValue(String configName, String propertyName, Class<?> type) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        String value = props.getProperties(configName, propertyName);
        Object obj = null;

        try {
            if (type.equals(Integer.class)) {
                obj = Integer.valueOf(value);

            } else if (type.equals(Boolean.class)) {
                obj = Boolean.valueOf(value);

            } else if (type.equals(Float.class)) {
                obj = Float.valueOf(value);

            } else if (type.equals(Date.class)) {
                obj = format.parse(value);

            } else if (type.equals(String.class)) {
                obj = new String();
                obj = value;
            }

        } catch (IllegalArgumentException | ParseException e) {
            e.printStackTrace();
        }

        return obj;
    }
}
