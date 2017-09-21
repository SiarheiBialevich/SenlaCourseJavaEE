package ru.senla.bialevich.flowers;

public class Azalea extends AbstractFlowers {

    public Azalea(String name, Integer price) {
        super(name, price);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Azalea{");
        sb.append("name='").append(name).append('\'');
        sb.append(", price=").append(price);
        sb.append('}');
        return sb.toString();
    }


}
