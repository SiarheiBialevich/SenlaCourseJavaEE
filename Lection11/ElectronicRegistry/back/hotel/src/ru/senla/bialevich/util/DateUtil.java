package ru.senla.bialevich.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    private final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

    public Date create (String date) throws ParseException {
        return DATE_FORMAT.parse(date);
    }



}
