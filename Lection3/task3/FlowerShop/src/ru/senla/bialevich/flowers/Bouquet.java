package ru.senla.bialevich.flowers;

import java.util.Arrays;

public class Bouquet {
    private AbstractFlowers[] bouquet;
    private Integer count = 0;
    private Integer totalPrice = 0;

    public Bouquet(Integer countFlowers) {
        bouquet = new AbstractFlowers[countFlowers];
    }

    public void put(AbstractFlowers flowers) {
        bouquet[count] = flowers;

        count++;
    }

    public void getBouquet() {
        for (AbstractFlowers aBouquet : bouquet) {
            totalPrice += aBouquet.getPrice();
        }

        System.out.println(toString());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("The total cost of the bouquet of: ");
        sb.append("\n").append(Arrays.toString(bouquet));
        sb.append(". Total price: ").append(totalPrice);
        return sb.toString();
    }
}
