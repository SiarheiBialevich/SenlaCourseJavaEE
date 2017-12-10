package ru.senla.bialevich.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 8456647581162743717L;

    private Integer id;
    private Integer orderNumber;
    private Date dateOfArrival;
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
