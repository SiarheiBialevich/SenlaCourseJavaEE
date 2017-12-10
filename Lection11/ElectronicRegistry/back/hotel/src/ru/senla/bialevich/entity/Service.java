package ru.senla.bialevich.entity;

import ru.senla.bialevich.enums.entity.ServicesSection;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Service extends BaseEntity implements Serializable {
    private static final long serialVersionUID = -3980863425685185211L;

    private Integer id;
    private String name;
    private Double price;
    private ServicesSection section;
    private Date starDate;
    private Date finalDate;
    private Guest guest;

    public Service() {
    }

    public Service(String name, Double price, ServicesSection section, Date starDate, Date finalDate) {
        this.name = name;
        this.price = price;
        this.section = section;
        this.starDate = starDate;
        this.finalDate = finalDate;
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

    public ServicesSection getSection() {
        return section;
    }

    public void setSection(ServicesSection section) {
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
        return Objects.equals(id, service.id) &&
                Objects.equals(name, service.name) &&
                Objects.equals(price, service.price) &&
                section == service.section &&
                Objects.equals(starDate, service.starDate) &&
                Objects.equals(finalDate, service.finalDate) &&
                Objects.equals(guest, service.guest);
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
        sb.append(", guest=").append(guest);
        sb.append('}');
        return sb.toString();
    }
}
