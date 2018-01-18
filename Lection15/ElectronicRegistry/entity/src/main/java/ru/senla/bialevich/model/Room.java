package ru.senla.bialevich.model;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import ru.senla.bialevich.enums.RoomSection;
import ru.senla.bialevich.enums.RoomStatus;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "room")
public class Room extends BaseEntity implements Cloneable, Serializable {
    private static final long serialVersionUID = -4085288967304236682L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "price")
    private Double price;

    @Column(name = "capacity")
    private Integer capacity;

    @Column(name = "status")
    private String status;

    @Column(name = "section")
    private String section;

    @Column(name = "rating")
    private Integer rating;

    @OneToMany(mappedBy = "room", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Guest> guests = new ArrayList<>();

    public Room() {
    }

    public Room(Double price, Integer capacity, String section, Integer rating) {
        this.price = price;
        this.capacity = capacity;
        this.status = "free";
        this.section = section;
        this.rating = rating;
        this.guests = new ArrayList<>();
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
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

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return Objects.equals(id, room.id);
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
        sb.append('}');
        return sb.toString();
    }
}
