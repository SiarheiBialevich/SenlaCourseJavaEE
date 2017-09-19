package ru.senla.bialevich.impl.linestep;

import ru.senla.bialevich.api.ILineStep;
import ru.senla.bialevich.api.IProductPart;
import ru.senla.bialevich.impl.productpart.MonitorImpl;

public class CreateMonitorImpl implements ILineStep {

    @Override
    public IProductPart buildProductPart() {
        System.out.println("Monitor created");

        return new MonitorImpl("Apple");
    }
}
