package ru.senla.bialevich.util.comparator.usedServiceComparator;

import ru.senla.bialevich.entity.UsedService;

import java.util.Comparator;

public class UsedServicePriceComparator implements Comparator<UsedService> {
    @Override
    public int compare(UsedService o1, UsedService o2) {
        if (o1.getPrice() == null) {
            return (o2.getPrice() == null) ? 0 : -1;
        }
        if (o2.getPrice() == null) {
            return 1;
        }
        return o1.getPrice().compareTo(o2.getPrice());
    }
}
