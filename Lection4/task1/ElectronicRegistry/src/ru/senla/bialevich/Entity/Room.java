package ru.senla.bialevich.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Room extends BaseEntity implements Serializable {
    private static final long serialVersionUID = -4085288967304236682L;

    private Integer id;
    private Integer roomNumber;
    private Integer countStars;
    private Integer countOfBeds;
    private boolean isFree = true;
    private Float price;
    private List<Guest> guestList = new ArrayList<>();
    private List<UsedService> usedServiceList = new ArrayList<>();

    public Room(Integer roomNumber, Integer countStars, Integer countOfBeds, boolean isFree, Float price) {
        this.roomNumber = roomNumber;
        this.countStars = countStars;
        this.countOfBeds = countOfBeds;
        this.isFree = isFree;
        this.price = price;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
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

        for (UsedService usedService : usedServiceList) {
            if (usedService.getPrice() != null)
                coast += usedService.getPrice();
        }

        return coast + price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public List<UsedService> getUsedServiceList() {
        return usedServiceList;
    }

    public void setUsedServiceList(List<UsedService> usedServiceList) {
        this.usedServiceList = usedServiceList;
    }

    public void addGuest(Guest guest) {
        guestList.add(guest);
    }

    public void addService(UsedService usedService) {
        usedServiceList.add(usedService);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Room{");
        sb.append("roomNumber = ").append(roomNumber);
        sb.append(", countStars = ").append(countStars);
        sb.append(", countOfBeds = ").append(countOfBeds);
        sb.append(", isFree = ").append(isFree);
        sb.append(", usedService = ").append(usedServiceList);
        sb.append(", price = ").append(price);
        sb.append('}');
        return sb.toString();
    }
}
