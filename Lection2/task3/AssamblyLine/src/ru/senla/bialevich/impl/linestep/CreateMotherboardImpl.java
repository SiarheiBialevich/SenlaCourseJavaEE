package ru.senla.bialevich.impl.linestep;

import ru.senla.bialevich.api.ILineStep;
import ru.senla.bialevich.api.IProductPart;
import ru.senla.bialevich.impl.productpart.MotherboardImpl;

public class CreateMotherboardImpl implements ILineStep {
    private MotherboardImpl motherboard = new MotherboardImpl("Samsung");

    @Override
    public IProductPart buildProductPart() {
        System.out.println("Motherboar " + motherboard.getName() + " created");

        return motherboard;
    }
}
