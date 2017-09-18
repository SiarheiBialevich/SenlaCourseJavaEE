package ru.senla.bialevich.impl.linestep;

import ru.senla.bialevich.api.ILineStep;
import ru.senla.bialevich.api.IProductPart;
import ru.senla.bialevich.impl.productpart.MonitorImpl;

public class CreateMonitorImpl implements ILineStep {
    private MonitorImpl monitor = new MonitorImpl("Apple");

    @Override
    public IProductPart buildProductPart() {
        System.out.println("Monitor " + monitor.getName() + " created");

        return monitor;
    }
}
