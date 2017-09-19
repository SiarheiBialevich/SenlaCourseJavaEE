package ru.senla.bialevich.impl.productpart;

import ru.senla.bialevich.api.IProductPart;

public class MotherboardImpl implements IProductPart {
    private String name;

    public MotherboardImpl(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("MotherboardImpl{");
        sb.append("name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
