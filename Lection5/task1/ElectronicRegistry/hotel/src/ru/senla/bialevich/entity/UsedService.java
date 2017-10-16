package ru.senla.bialevich.entity;

import java.io.Serializable;

public class UsedService extends BaseEntity implements Serializable {
    private static final long serialVersionUID = -3980863425685185211L;

    private Integer id;
    private String nameService;
    private Guest guest;
    private Float price;

    public UsedService(String nameService, Float price) {
        this.nameService = nameService;
        this.price = price;
    }

    public UsedService(Integer id, String nameService, Float price) {
        this.id = id;
        this.nameService = nameService;
        this.price = price;
    }

    public UsedService(Integer id, String nameService, Guest guest, Float price) {
        this.id = id;
        this.nameService = nameService;
        this.guest = guest;
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

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UsedService{");
        sb.append("nameService='").append(nameService).append('\'');
        sb.append(", price=").append(price);
        sb.append('}');
        return sb.toString();
    }
}
