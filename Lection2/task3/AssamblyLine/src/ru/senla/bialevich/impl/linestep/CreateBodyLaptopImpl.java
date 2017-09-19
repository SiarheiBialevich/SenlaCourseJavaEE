package ru.senla.bialevich.impl.linestep;

import ru.senla.bialevich.api.ILineStep;
import ru.senla.bialevich.api.IProductPart;
import ru.senla.bialevich.impl.productpart.BodyLaptopImpl;

public class CreateBodyLaptopImpl implements ILineStep {

    @Override
    public IProductPart buildProductPart() {
        System.out.println("Body created");

        return new BodyLaptopImpl("Asus");
    }
}
