package ru.senla.bialevich.annotations;

import java.util.Date;

public class Test {

    @ConfigProperty(configName = "annotation.properties", propertyName = "test", type = String.class)
    private String test;

    @ConfigProperty(configName = "annotation.properties", propertyName = "date", type = Date.class)
    private Date date;

    @ConfigProperty(configName = "annotation.properties", propertyName = "is.configure", type = Boolean.class)
    private Boolean isConfigure;
}
