package ru.senla.bialevich.annotations;

import org.apache.log4j.Logger;
import ru.senla.bialevich.annotations.util.PropertyUtil;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AnnotationWorker {
    private static final Logger LOG = Logger.getLogger(AnnotationWorker.class);
    private static final String PATH = "annotation.properties";
    private SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

    private PropertyUtil props = new PropertyUtil();

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

                if (field.getAnnotation(ConfigProperty.class).configName().isEmpty()) {
                    configName = PATH;
                } else {
                    configName = field.getAnnotation(ConfigProperty.class).configName();
                }

                if (field.getAnnotation(ConfigProperty.class).propertyName().isEmpty()) {
                    StringBuffer sb = new StringBuffer();
                    sb.append(cl.getSimpleName()).append(".").append(field.getName());
                    propertyName = sb.toString();
                } else {
                    propertyName = field.getAnnotation(ConfigProperty.class).propertyName();
                }

                if (field.getAnnotation(ConfigProperty.class).type().equals(Object.class)) {
                    type = field.getType();
                } else {
                    type = field.getAnnotation(ConfigProperty.class).type();
                }

                try {
                    if (type.equals(Integer.class)) {
                        field.setInt(object, Integer.parseInt(props.getProperties(configName, propertyName)));
                    } else if (type.equals(String.class)) {
                        field.set(object, props.getProperties(configName, propertyName));
                    } else if (type.equals(Boolean.class)) {
                        field.set(object, Boolean.parseBoolean(props.getProperties(configName, propertyName)));
                    } else if (type.equals(Float.class)) {
                        field.set(object, Float.parseFloat(props.getProperties(configName, propertyName)));
                    } else if (type.equals(Date.class)) {
                        field.set(object, format.parse(props.getProperties(configName, propertyName)));
                    }
                } catch (IllegalArgumentException | IllegalAccessException | ParseException e) {
                    LOG.error(e.getMessage(), e);
                } finally {
                    field.setAccessible(isAccessible);
                }
            }
        }

        return object;
    }
}
