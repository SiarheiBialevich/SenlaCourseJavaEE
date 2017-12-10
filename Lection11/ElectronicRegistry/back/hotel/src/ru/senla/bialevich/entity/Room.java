package ru.senla.bialevich.entity;

import ru.senla.bialevich.enums.entity.RoomSection;
import ru.senla.bialevich.enums.entity.RoomStatus;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Room extends BaseEntity implements Cloneable, Serializable {
    private static final long serialVersionUID = -4085288967304236682L;

    private Integer id;

    private Double price;
    private Integer capacity;
    private RoomStatus status;
    private RoomSection section;
    private Integer rating;
    private List<Guest> guests = new ArrayList<>();
    private List<Registration> registrations = new ArrayList<>();

    public Room() {
    }

    public Room(Double price, Integer capacity, RoomSection section, Integer rating) {
        this.price = price;
        this.capacity = capacity;
        this.section = section;
        this.rating = rating;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public RoomStatus getStatus() {
        return status;
    }

    public void setStatus(RoomStatus status) {
        this.status = status;
    }

    public RoomSection getSection() {
        return section;
    }

    public void setSection(RoomSection section) {
        this.section = section;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public List<Guest> getGuests() {
        return guests;
    }

    public void setGuests(List<Guest> guests) {
        this.guests = guests;
    }

    public List<Registration> getRegistrations() {
        return registrations;
    }

    public void setRegistrations(List<Registration> registrations) {
        this.registrations = registrations;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return Objects.equals(id, room.id) &&
                Objects.equals(price, room.price) &&
                Objects.equals(capacity, room.capacity) &&
                status == room.status &&
                section == room.section &&
                Objects.equals(rating, room.rating) &&
                Objects.equals(guests, room.guests) &&
                Objects.equals(registrations, room.registrations);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Room{");
        sb.append("id=").append(id);
        sb.append(", price=").append(price);
        sb.append(", capacity=").append(capacity);
        sb.append(", status=").append(status);
        sb.append(", section=").append(section);
        sb.append(", rating=").append(rating);
        sb.append(", guests=").append(guests);
        sb.append(", registrations=").append(registrations);
        sb.append('}');
        return sb.toString();
    }
}
