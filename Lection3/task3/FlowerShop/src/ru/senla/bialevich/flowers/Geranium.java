package ru.senla.bialevich.flowers;

public class Geranium extends AbstractFlowers {

    public Geranium(String name, Integer price) {
        super(name, price);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Geranium{");
        sb.append("name='").append(name).append('\'');
        sb.append(", price=").append(price);
        sb.append('}');
        return sb.toString();
    }
}
