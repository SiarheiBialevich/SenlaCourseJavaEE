package ru.senla.bialevich.impl.product;

import ru.senla.bialevich.api.IProduct;
import ru.senla.bialevich.api.IProductPart;

public class LaptopImpl implements IProduct {

    @Override
    public void installFirstPart(IProductPart productPart) {
        System.out.println("The body is installed");
    }

    @Override
    public void installSecondPart(IProductPart productPart) {
        System.out.println("The motherboard is installed");
    }

    @Override
    public void installThirdPart(IProductPart productPart) {
        System.out.println("The monitor is installed");
    }
}
