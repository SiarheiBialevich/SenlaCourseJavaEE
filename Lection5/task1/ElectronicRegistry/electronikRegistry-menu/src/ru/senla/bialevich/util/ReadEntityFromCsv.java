package ru.senla.bialevich.util;

import ru.senla.bialevich.entity.BaseEntity;

import java.util.List;

public interface ReadEntityFromCsv<T extends BaseEntity> {
    List<T> read(String file);
}
