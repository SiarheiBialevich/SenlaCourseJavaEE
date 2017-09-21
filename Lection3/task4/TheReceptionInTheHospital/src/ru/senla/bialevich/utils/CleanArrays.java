package ru.senla.bialevich.utils;

import ru.senla.bialevich.Clinic.AbstractMan;

public class CleanArrays {

    public AbstractMan[] cleanArray(AbstractMan[] man) {
        Integer count = 0;

        for (AbstractMan aMan : man) {
            if (aMan != null) {
                count++;
            }
        }

        AbstractMan[] mans = new AbstractMan[count];
        Integer k = 0;

        for (AbstractMan aMan : man) {

            if (aMan != null) {
                mans[k] = aMan;
                k++;
            }
        }

        return mans;
    }
}
