package ru.senla.bialevich.entity;

import java.io.Serializable;

public class Guest extends BaseEntity implements Serializable {
    private static final long serialVersionUID = -8798790623190134533L;

    private Integer id = 0;
    private String name;
    private String surname;
    private Room room;
    private Order order;

    public Guest(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Guest{");
        sb.append(" name = '").append(name).append('\'');
        sb.append(", surname = '").append(surname).append('\'');
        sb.append(", room = '").append(room).append('\'');
        sb.append(", order = ").append(order);
        sb.append('}');
        return sb.toString();
    }
}
