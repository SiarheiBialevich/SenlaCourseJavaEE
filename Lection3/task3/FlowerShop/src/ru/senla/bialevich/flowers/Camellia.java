package ru.senla.bialevich.flowers;

public class Camellia extends AbstractFlowers {

    public Camellia(String name, Integer price) {
        super(name, price);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Camellia{");
        sb.append("name='").append(name).append('\'');
        sb.append(", price=").append(price);
        sb.append('}');
        return sb.toString();
    }
}
