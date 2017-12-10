package ru.senla.bialevich.entity;

import ru.senla.bialevich.annotations.ConfigProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 8456647581162743717L;

    @ConfigProperty(configName = "annotation.properties", propertyName = "Order.id", type = Integer.class)
    private Integer id;

    @ConfigProperty(configName = "annotation.properties", propertyName = "Order.number", type = Integer.class)
    private Integer orderNumber;

    @ConfigProperty(configName = "annotation.properties", propertyName = "Order.date.of.arrival", type = Date.class)
    private Date dateOfArrival;

    @ConfigProperty(configName = "annotation.properties", propertyName = "Order.date.of.departure", type = Date.class)
    private Date dateOfDeparture;
    private List<Guest> guestList = new ArrayList<Guest>();
    public static final String ENTITY_TOKEN = "Order";

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public Order(Integer orderNumber, Date dateOfArrival, Date dateOfDeparture) {
        this.orderNumber = orderNumber;
        this.dateOfArrival = dateOfArrival;
        this.dateOfDeparture = dateOfDeparture;
    }

    public Order() {
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Date getDateOfArrival() {
        return dateOfArrival;
    }

    public void setDateOfArrival(Date dateOfArrival) {
        this.dateOfArrival = dateOfArrival;
    }

    public Date getDateOfDeparture() {
        return dateOfDeparture;
    }

    public void setDateOfDeparture(Date dateOfDeparture) {
        this.dateOfDeparture = dateOfDeparture;
    }

    public void addGuest(Guest guest) {
        guestList.add(guest);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Order{");
        sb.append(" orderNumber = ").append(orderNumber);
        sb.append(", dateOfArrival = ").append(dateOfArrival);
        sb.append(", dateOfDeparture = ").append(dateOfDeparture);
        sb.append('}');
        return sb.toString();
    }
}
