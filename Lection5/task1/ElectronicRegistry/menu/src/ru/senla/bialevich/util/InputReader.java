package ru.senla.bialevich.util;

import org.apache.log4j.Logger;

import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

public class InputReader {
    private Printer printer = new Printer();
    private FormatString format = new FormatString();
    private DateUtil dateUtil = new DateUtil();
    private static final Logger log = Logger.getLogger(Integer.class);

    public Integer getInputInt(Scanner scanner, String message) {
        printer.print(message);

        return getInputInt(scanner);
    }

    public String getInputString(Scanner scanner, String message) {
        printer.print(message);

        return getInputString(scanner);
    }

    public Float getInputFloat(Scanner scanner, String message) {
        printer.print(message);

        return getInputFloat(scanner);
    }

    public Date getInputDate(Scanner scanner, String message) {
        printer.print(message);

        return getInputDate(scanner);
    }

    public Integer getInputInt(Scanner scanner) {
        boolean isValid = false;
        Integer input = null;

        while (!isValid) {
            if (scanner.hasNextInt()) {
                input = scanner.nextInt();
                isValid = true;
            } else {
                printer.print("Error input. Please enter tye number.");
                scanner.nextLine();
                continue;
            }
        }

        return input;
    }

    private String getInputString(Scanner scanner) {
        boolean isValid = false;
        String formatString = null;

        while (!isValid) {
            if (scanner.hasNext()) {
                formatString = format.formatUserString(scanner.next().toLowerCase());

                if (formatString.isEmpty()) {
                    printer.print("Error input. Please enter the string.");
                    scanner.nextLine();
                    continue;
                } else {
                    isValid = true;
                }
            }
        }

        return formatString;
    }

    private Float getInputFloat(Scanner scanner) {
        boolean isValid = false;
        Float input = -1.0f;

        while (!isValid) {
            if (scanner.hasNextFloat()) {
                input = scanner.nextFloat();
                isValid = true;
            } else {
                printer.print("Error input. Please enter the float number.");
                scanner.nextLine();
                continue;
            }
        }

        return input;
    }

    private Date getInputDate(Scanner scanner) {
        boolean isValid = false;
        String userDataString;
        Date date = null;

        while (!isValid) {
            if (scanner.hasNext()) {
                userDataString = scanner.next();
                try {
                    date = dateUtil.create(userDataString);
                } catch (ParseException e) {
                    log.error("Incorrect input date.", e);
                }
                isValid = true;
            } else {
                printer.print("Error input. Please enter the date.");
                scanner.nextLine();
                continue;
            }
        }

        return date;
    }
}
