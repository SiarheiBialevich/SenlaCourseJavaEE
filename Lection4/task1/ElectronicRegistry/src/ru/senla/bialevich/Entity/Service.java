package ru.senla.bialevich.Entity;

import java.io.Serializable;

public class Service implements Serializable {
    private static final long serialVersionUID = -3980863425685185211L;

    private String nameService;
    private Guest guest;
    private Float price;

    public Service(String nameService, Float price) {
        this.nameService = nameService;
        this.price = price;
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
        final StringBuilder sb = new StringBuilder("Service{");
        sb.append("nameService='").append(nameService).append('\'');
        sb.append(", price=").append(price);
        sb.append('}');
        return sb.toString();
    }
}
