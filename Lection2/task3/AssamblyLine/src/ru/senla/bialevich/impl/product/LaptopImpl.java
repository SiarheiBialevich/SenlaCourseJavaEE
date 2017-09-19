package ru.senla.bialevich.impl.product;

import ru.senla.bialevich.api.IProduct;
import ru.senla.bialevich.api.IProductPart;

public class LaptopImpl implements IProduct {
    private IProductPart productPart1;
    private IProductPart productPart2;
    private IProductPart productPart3;

    @Override
    public void installFirstPart(IProductPart productPart) {
        productPart1 = productPart;
        System.out.println("The body is installed");
    }

    @Override
    public void installSecondPart(IProductPart productPart) {
        productPart2 = productPart;
        System.out.println("The motherboard is installed");
    }

    @Override
    public void installThirdPart(IProductPart productPart) {
        productPart3 = productPart;
        System.out.println("The monitor is installed");
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("LaptopImpl{");
        sb.append("productPart1=").append(productPart1);
        sb.append(", productPart2=").append(productPart2);
        sb.append(", productPart3=").append(productPart3);
        sb.append('}');
        return sb.toString();
    }
}
