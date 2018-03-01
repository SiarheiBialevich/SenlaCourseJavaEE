package ru.senla.bialevich.entity;

import java.io.Serializable;

public abstract class BaseEntity implements Serializable {
    private static final long serialVersionUID = -3929422220718196705L;

    protected abstract Integer getId();

    protected abstract void setId(Integer id);
}
