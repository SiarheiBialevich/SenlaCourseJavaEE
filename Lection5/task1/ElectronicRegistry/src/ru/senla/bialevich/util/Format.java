package ru.senla.bialevich.util;

public class Format {

    public String formatUserString(String text) {

        return text.replaceAll("\\d", "");
    }
}
