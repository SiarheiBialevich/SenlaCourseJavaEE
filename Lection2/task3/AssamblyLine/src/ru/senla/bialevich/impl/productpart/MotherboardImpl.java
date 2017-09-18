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
}
