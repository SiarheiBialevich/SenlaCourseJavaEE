package ru.senla.bialevich.entity;

import ru.senla.bialevich.util.Printer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Room extends BaseEntity implements Cloneable, Serializable {
    private static final long serialVersionUID = -4085288967304236682L;

    private Printer printer = new Printer();

    private Integer id;
    private Integer roomNumber;
    private Integer countStars;
    private Integer capacity;
    private boolean isFree = true;
    private Float price;
    private List<Guest> guestList = new ArrayList<>();
    private List<UsedService> usedServiceList = new ArrayList<>();

    public Room(Integer roomNumber, Integer countStars, Integer capacity, boolean isFree, Float price) {
        this.roomNumber = roomNumber;
        this.countStars = countStars;
        this.capacity = capacity;
        this.isFree = isFree;
        this.price = price;
    }

    public Room(Integer roomNumber, Integer countStars, Integer capacity, Float price) {
        this.roomNumber = roomNumber;
        this.countStars = countStars;
        this.capacity = capacity;
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

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
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

    public void addService(UsedService usedService) {
        usedServiceList.add(usedService);
    }

    public void addGuest(Guest guest) {
        if (guest.getRoom() != null) {
            printer.print("Guest room is already");
        }
        if (guestList == null) {
            guestList = new ArrayList<>();
        }
        if (guestList.size() < capacity) {
            guestList.add(guest);
            isFree = false;
        } else {
            printer.print("Is full");
        }
    }

    public void removeGuest(Guest guest) {
        if (guestList == null) {
           printer.print("Guests is empty");
        }

        for (int i = 0; i < guestList.size(); i++) {
            if (guestList.get(i).getId() == guest.getId()) {
                guestList.remove(i);
                return;
            }

            printer.print("Guest not found");
        }
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Room{");
        sb.append("id=").append(id);
        sb.append(", roomNumber=").append(roomNumber);
        sb.append(", countStars=").append(countStars);
        sb.append(", capacity=").append(capacity);
        sb.append(", isFree=").append(isFree);
        sb.append(", price=").append(price);
//        sb.append(", usedServiceList=").append(usedServiceList);
        sb.append('}');
        return sb.toString();
    }
}
