package ru.senla.bialevich.util;

public class Printer {
    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printObject(Object object) {
        System.out.println(object);
    }

    public void printMessageAndObject(String message, Object object) {
        printMessage(message);
        System.out.println(object);
    }

    public void printInfo(String message, Object object, Object object1) {
        printMessage(message);
        printObject(object);
        System.out.println(object1);
    }
}
