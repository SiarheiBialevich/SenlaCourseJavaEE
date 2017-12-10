package ru.senla.bialevich.util;

import java.util.Arrays;
import java.util.List;

public class AnArrayOfStrings {

    public String[] getStringArray(List list) {
        String[] strings = new String[list.size()];
        String splitString;

        for (int i = 0; i < list.size(); i++) {
            splitString =String.valueOf(list.get(i));

//            strings[i] = String.valueOf(list.get(i));
            strings[i] = Arrays.toString(splitString.trim().split("[,;:\\{\\}\\[\\]='!?\\s]+")).
                    replace("[", "").replace("]", "");

        }
        return strings;
    }
}
