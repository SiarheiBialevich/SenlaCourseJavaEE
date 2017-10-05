package ru.senla.bialevich.util.writeAndRaed;

import ru.senla.bialevich.entity.BaseEntity;

import java.util.List;

public class AnArrayOfStrings {

    public String[] getStringArray(List list) {
        String[] strings = new String[list.size()];

        for (int i = 0; i < list.size(); i++) {
            strings[i] = String.valueOf(list.get(i));
        }

        return strings;
    }
}
