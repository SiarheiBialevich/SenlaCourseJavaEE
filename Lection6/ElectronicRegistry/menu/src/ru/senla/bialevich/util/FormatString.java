package ru.senla.bialevich.util;

public class FormatString {

    public String formatUserString(String text) {

        return text.replaceAll("\\d", "");
    }
}
