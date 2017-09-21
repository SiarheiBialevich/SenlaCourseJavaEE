package ru.senla.bialevich.run;

import ru.senla.bialevich.flowers.*;

public class Run {
    public static void main(String[] args) {
        Bouquet bouquet = new Bouquet(3);

        bouquet.put(new Rose("Marvell", 50));
        bouquet.put(new Camellia("Japonica", 20));
        bouquet.put(new Azalea("Doberlug", 30));

        bouquet.getBouquet();

        Bouquet bouquet1 = new Bouquet(5);

        bouquet1.put(new Rose("Marvell", 50));
        bouquet1.put(new Camellia("Japonica", 20));
        bouquet1.put(new Geranium("Ann Folkard", 15));
        bouquet1.put(new Geranium("Cantabrigiense", 15));
        bouquet1.put(new Azalea("Doberlug", 30));

        bouquet1.getBouquet();
    }
}
