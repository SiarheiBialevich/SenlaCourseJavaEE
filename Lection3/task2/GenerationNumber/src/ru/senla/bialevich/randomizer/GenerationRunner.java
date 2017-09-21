package ru.senla.bialevich.randomizer;

public class GenerationRunner {
    private RandomNumber rnd = new RandomNumber();

    public void start() {
        System.out.print(rnd.getMaxNumber(rnd.getRandomNumber()));
    }
}
