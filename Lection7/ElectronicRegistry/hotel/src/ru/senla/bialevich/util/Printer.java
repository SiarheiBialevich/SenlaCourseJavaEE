package ru.senla.bialevich.util;

import java.util.List;

public class Printer {

    public void print(String message) {
        System.out.println(message);
    }

    public void print(Object object) {
        System.out.println(object);
    }

    public void print(String message, Object object) {
        print(message);
        print(object);
    }

    public void print(String message, Object object, Object object1) {
        System.out.print(message);
        print(object);
        print(object1);
    }

    public void print(List list) {
        for (int i = 0; i < list.size(); i++) {
            print(list.get(i));
        }
    }

}
