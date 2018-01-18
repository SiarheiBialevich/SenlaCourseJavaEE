package ru.senla.bialevich.util;

import ru.senla.bialevich.model.BaseEntity;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CopyAndSortList<T extends BaseEntity> {

    public List<T> getCopiedAndSortedList(List<T> list, Comparator<T> comparator) {
        List<T> copiedArray = new ArrayList<T>(list);
        copiedArray.sort(comparator);

        return copiedArray;
    }
}
