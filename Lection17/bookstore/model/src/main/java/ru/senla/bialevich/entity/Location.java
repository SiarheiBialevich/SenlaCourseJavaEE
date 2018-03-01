package ru.senla.bialevich.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "location")
public class Location extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "title")
    private String titleLocation;

    @OneToMany(mappedBy = "location")
    private List<BookLocation> bookLocations;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_citys_id")
    private City city;


    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getTitleLocation() {
        return titleLocation;
    }

    public void setTitleLocation(String titleLocation) {
        this.titleLocation = titleLocation;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public List<BookLocation> getBookLocations() {
        return bookLocations;
    }

    public void setBookLocations(List<BookLocation> bookLocations) {
        this.bookLocations = bookLocations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return Objects.equals(id, location.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}
