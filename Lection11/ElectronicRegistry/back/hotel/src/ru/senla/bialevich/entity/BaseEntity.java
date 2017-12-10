package ru.senla.bialevich.entity;

import java.io.Serializable;

public abstract class BaseEntity implements Serializable {
    private static final long serialVersionUID = 5857342671914823487L;

    public abstract Integer getId();

    protected abstract void setId(Integer id);
}
