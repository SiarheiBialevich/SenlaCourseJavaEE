package ru.senla.bialevich.randomizer;

import ru.senla.bialevich.util.Printer;

public class GenerationRunner {
    private RandomNumber randomNumber = new RandomNumber();
    private CalculateMaxNumber calculateMaxNumber = new CalculateMaxNumber();
    private Printer printer = new Printer();

    public void maxNumber() {
        String GENERATE_NUM = "The generated number - ";
        String MAX_NUM = "The max number - ";

        StringBuilder sb = new StringBuilder();

        Integer random = randomNumber.getRandomNumber();
        Integer maxNumber = calculateMaxNumber.getMaxNumber(random);

        sb.append(GENERATE_NUM).append(random).append("\n");
        sb.append(MAX_NUM).append(maxNumber);

        printer.printMessage(sb.toString());
    }
}
