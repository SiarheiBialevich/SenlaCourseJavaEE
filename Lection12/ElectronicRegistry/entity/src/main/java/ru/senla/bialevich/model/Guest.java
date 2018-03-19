package ru.senla.bialevich.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "guest")
public class Guest extends BaseEntity implements Serializable {
    private static final long serialVersionUID = -8798790623190134533L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_room_id")
    private Room room;

    @OneToMany(mappedBy = "guest", fetch = FetchType.LAZY)
    private List<Service> services;

    public Guest(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.services = null;
        this.room = null;
    }

    public Guest() {
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

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Guest guest = (Guest) o;
        return Objects.equals(id, guest.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }

//    @Override
//    public String toString() {
//        final StringBuilder sb = new StringBuilder("Guest{");
//        sb.append("id=").append(id);
//        sb.append(", name='").append(name).append('\'');
//        sb.append(", surname='").append(surname).append('\'');
//        sb.append(", room=").append(room);
//        sb.append(", services=").append(services);
//        sb.append('}');
//        return sb.toString();
//    }
}
