package ru.senla.bialevich.flowers;

public class Rose extends AbstractFlowers {

    public Rose(String name, Integer price) {
        super(name, price);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Rose{");
        sb.append("name='").append(name).append('\'');
        sb.append(", price=").append(price);
        sb.append('}');
        return sb.toString();
    }
}
