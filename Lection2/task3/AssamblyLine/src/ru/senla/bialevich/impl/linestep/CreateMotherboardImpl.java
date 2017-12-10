package ru.senla.bialevich.impl.linestep;

import ru.senla.bialevich.api.ILineStep;
import ru.senla.bialevich.api.IProductPart;
import ru.senla.bialevich.impl.productpart.MotherboardImpl;

public class CreateMotherboardImpl implements ILineStep {

    @Override
    public IProductPart buildProductPart() {
        System.out.println("Motherboard created");

        return new MotherboardImpl("Samsung");
    }
}
