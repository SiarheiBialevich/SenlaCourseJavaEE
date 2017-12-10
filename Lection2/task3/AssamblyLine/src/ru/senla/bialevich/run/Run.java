package ru.senla.bialevich.run;

import ru.senla.bialevich.impl.assemblyline.AssemblyLineImpl;
import ru.senla.bialevich.impl.linestep.CreateBodyLaptopImpl;
import ru.senla.bialevich.impl.linestep.CreateMonitorImpl;
import ru.senla.bialevich.impl.linestep.CreateMotherboardImpl;
import ru.senla.bialevich.impl.product.LaptopImpl;

public class Run {
    public static void main(String[] args) {
        CreateBodyLaptopImpl bodyLaptop = new CreateBodyLaptopImpl();
        CreateMotherboardImpl motherboard = new CreateMotherboardImpl();
        CreateMonitorImpl monitor = new CreateMonitorImpl();

        LaptopImpl laptop = new LaptopImpl();

        AssemblyLineImpl assemblyLine = new AssemblyLineImpl(bodyLaptop, motherboard, monitor);

        System.out.println(assemblyLine.assemblyProduct(laptop));
    }
}
