package ru.senla.bialevich.randomizer;

public class RandomNumber {
    private Integer randomNumber;
    private Integer max;

    Integer getRandomNumber() {
        randomNumber = 100 + (new java.util.Random()).nextInt(899);

        return randomNumber;
    }

    Integer getMaxNumber(Integer num) {
        Integer number1 = num / 100;
        Integer number2 = (num / 10) % 10;
        Integer number3 = num % 10;

        Integer[] numbers = {number1, number2, number3};

        max = numbers[0];
        for (Integer anArr : numbers) {
            if (max < anArr) {
                max = anArr;
            }
        }

        System.out.print(toString());
        return max;
    }

    @Override
    public String toString() {

        //noinspection StringBufferReplaceableByString
        final StringBuilder sb = new StringBuilder();
        sb.append("The generated random number - ").append(randomNumber).append("\n");
        sb.append("Max number - ");
        return sb.toString();
    }
}
