package ru.senla.bialevich.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;
import com.sun.deploy.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ServicesSection {

//    FOOD,
//
//    MANDATORY,
//
//    PLACE;

//    public static ServicesSection isExist(String string) {
//        for (ServicesSection section : ServicesSection.values()) {
//            if (section.toString().equals(string)) {
//                return section;
//            }
//        }
//        throw new IllegalArgumentException();
//    }


    FOOD("food"),

    MANDATORY("mandatory"),

    PLACE("place");

    private String service;

    ServicesSection(String service) {
        this.service = service;
    }

    public String getService() {
        return service;
    }
}
