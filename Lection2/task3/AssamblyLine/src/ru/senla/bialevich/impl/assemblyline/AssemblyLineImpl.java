package ru.senla.bialevich.impl.assemblyline;

import ru.senla.bialevich.api.IAssemblyLine;
import ru.senla.bialevich.api.ILineStep;
import ru.senla.bialevich.api.IProduct;

public class AssemblyLineImpl implements IAssemblyLine {
    private ILineStep bodyLaptop;
    private ILineStep motherboard;
    private ILineStep monitor;

    public AssemblyLineImpl(ILineStep bodyLaptop, ILineStep motherboard, ILineStep monitor) {
        this.bodyLaptop = bodyLaptop;
        this.motherboard = motherboard;
        this.monitor = monitor;
    }

    @Override
    public IProduct assemblyProduct(IProduct product) {
        product.installFirstPart(bodyLaptop.buildProductPart());
        product.installSecondPart(motherboard.buildProductPart());
        product.installThirdPart(monitor.buildProductPart());

        System.out.println("The build is completed successfully");

        return product;
    }
}
