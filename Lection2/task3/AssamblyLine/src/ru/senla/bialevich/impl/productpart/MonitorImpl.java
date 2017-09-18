package ru.senla.bialevich.impl.productpart;

import ru.senla.bialevich.api.IProductPart;

public class MonitorImpl implements IProductPart {
    private String name;

    public MonitorImpl(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

