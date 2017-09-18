package ru.senla.bialevich.impl.linestep;

import ru.senla.bialevich.api.ILineStep;
import ru.senla.bialevich.api.IProductPart;
import ru.senla.bialevich.impl.productpart.BodyLaptopImpl;

public class CreateBodyLaptopImpl implements ILineStep {
    private BodyLaptopImpl bodyLaptop = new BodyLaptopImpl("Asus");


    @Override
    public IProductPart buildProductPart() {
        System.out.println("Body " + bodyLaptop.getName() + " created");

        return bodyLaptop;
    }
}
