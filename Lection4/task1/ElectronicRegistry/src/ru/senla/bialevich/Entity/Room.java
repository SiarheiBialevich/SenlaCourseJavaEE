package ru.senla.bialevich.Entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Room implements Serializable {
    private static final long serialVersionUID = -4085288967304236682L;

    private Integer roomNumber;
    private Integer countStars;
    private Integer countOfBeds;
    private boolean isFree = true;
    private Float price;
    private List<Guest> guestList = new ArrayList<Guest>();
    private List<Service> serviceList = new ArrayList<Service>();

    public Room(Integer roomNumber, Integer countStars, Integer countOfBeds, boolean isFree, Float price) {
        this.roomNumber = roomNumber;
        this.countStars = countStars;
        this.countOfBeds = countOfBeds;
        this.isFree = isFree;
        this.price = price;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public List<Guest> getGuestList() {
        return guestList;
    }

    public void setGuestList(List<Guest> guestList) {
        this.guestList = guestList;
    }

    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean free) {
        isFree = free;
    }

    public Integer getCountOfBeds() {
        return countOfBeds;
    }

    public void setCountOfBeds(Integer countOfBeds) {
        this.countOfBeds = countOfBeds;
    }

    public Integer getCountStars() {
        return countStars;
    }

    public void setCountStars(Integer countStars) {
        this.countStars = countStars;
    }

    public Float getPrice() {
        Float coast = 0.0f;

        for (Service service : serviceList) {
            if (service.getPrice() != null)
                coast += service.getPrice();
        }

        return coast + price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public void addGuest(Guest guest) {
        guestList.add(guest);
    }

    public void addService(Service service) {
        serviceList.add(service);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Room{");
        sb.append("roomNumber=").append(roomNumber);
        sb.append(", countStars=").append(countStars);
        sb.append(", countOfBeds=").append(countOfBeds);
        sb.append(", isFree=").append(isFree);
        sb.append(", price=").append(price);
        sb.append(", serviceList=").append(serviceList);
        sb.append('}');
        return sb.toString();
    }
}
