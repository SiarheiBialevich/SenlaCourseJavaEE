package ru.senla.bialevich.randomizer;

public class RandomNumber {

    Integer getRandomNumber() {

        return 100 + (new java.util.Random()).nextInt(899);
    }
}
