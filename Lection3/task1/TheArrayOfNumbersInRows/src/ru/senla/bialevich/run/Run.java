package ru.senla.bialevich.run;

import ru.senla.bialevich.ArrayOfString;

public class Run {
    public static void main(String[] args) {
        ArrayOfString ofString = new ArrayOfString("10", "20", "25");

        System.out.print(ofString.getAmountNumbers(ofString.getArrayString()));
    }

}
