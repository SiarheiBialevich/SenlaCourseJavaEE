package ru.senla.bialevich.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import com.fasterxml.jackson.annotation.JsonIgnore;
import ru.senla.bialevich.enums.ServicesSection;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "service")
public class Service extends BaseEntity implements Serializable {
    private static final long serialVersionUID = -3980863425685185211L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Double price;

    @Column(name = "section")
    private String section;

    @Column(name = "start_date")
    private Date starDate;

    @Column(name = "final_date")
    private Date finalDate;

    @ManyToOne
    @JoinColumn(name = "fk_guest_id")
    @JsonIgnore
    private Guest guest;

    public Service() {
    }

    public Service(String name, Double price, String section, Date starDate, Date finalDate) {
        this.name = name;
        this.price = price;
        this.section = section;
        this.starDate = starDate;
        this.finalDate = finalDate;
        this.guest = null;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public Date getStarDate() {
        return starDate;
    }

    public void setStarDate(Date starDate) {
        this.starDate = starDate;
    }

    public Date getFinalDate() {
        return finalDate;
    }

    public void setFinalDate(Date finalDate) {
        this.finalDate = finalDate;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Service service = (Service) o;
        return Objects.equals(id, service.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Service{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", price=").append(price);
        sb.append(", section=").append(section);
        sb.append(", starDate=").append(starDate);
        sb.append(", finalDate=").append(finalDate);
        sb.append('}');
        return sb.toString();
    }
}
