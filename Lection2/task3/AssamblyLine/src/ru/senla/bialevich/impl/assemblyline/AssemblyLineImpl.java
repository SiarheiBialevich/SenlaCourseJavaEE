package ru.senla.bialevich.impl.assemblyline;

import ru.senla.bialevich.api.IAssemblyLine;
import ru.senla.bialevich.api.IProduct;
import ru.senla.bialevich.impl.linestep.CreateBodyLaptopImpl;
import ru.senla.bialevich.impl.linestep.CreateMonitorImpl;
import ru.senla.bialevich.impl.linestep.CreateMotherboardImpl;

public class AssemblyLineImpl implements IAssemblyLine {
    private CreateBodyLaptopImpl bodyLaptop;
    private CreateMotherboardImpl motherboard;
    private CreateMonitorImpl monitor;

    public AssemblyLineImpl(CreateBodyLaptopImpl bodyLaptop, CreateMotherboardImpl motherboard, CreateMonitorImpl monitor) {
        this.bodyLaptop = bodyLaptop;
        this.motherboard = motherboard;
        this.monitor = monitor;
    }

    @Override
    public void assemblyProduct(IProduct product) {
        product.installFirstPart(bodyLaptop.buildProductPart());
        product.installSecondPart(motherboard.buildProductPart());
        product.installThirdPart(monitor.buildProductPart());

        System.out.println("The build is completed successfully");

    }
}
