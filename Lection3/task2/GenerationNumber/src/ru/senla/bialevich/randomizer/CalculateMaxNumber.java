package ru.senla.bialevich.randomizer;

public class CalculateMaxNumber {

    public Integer getMaxNumber(Integer num) {

        Integer number1 = num / 100;
        Integer number2 = (num / 10) % 10;
        Integer number3 = num % 10;

        Integer[] numbers = {number1, number2, number3};

        Integer max = numbers[0];

        for (Integer anArr : numbers) {
            if (max < anArr) {
                max = anArr;
            }
        }

        return max;
    }
}
