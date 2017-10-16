package ru.senla.bialevich.enums;

import ru.senla.bialevich.entity.UsedService;
import ru.senla.bialevich.util.comparator.usedServiceComparator.UsedServicePriceComparator;

import java.util.Comparator;

public enum ServiceSortComparator {
    SERVICE_PRICE(new UsedServicePriceComparator());

    private Comparator<UsedService> serviceComparator;

    ServiceSortComparator(Comparator<UsedService> serviceComparator) {
        this.serviceComparator = serviceComparator;
    }

    public Comparator<UsedService> getServiceComparator() {
        return serviceComparator;
    }
}
