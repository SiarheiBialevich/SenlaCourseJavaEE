package ru.senla.bialevich.entity;

import ru.senla.bialevich.annotations.ConfigProperty;

import java.io.Serializable;

public class UsedService extends BaseEntity implements Serializable {
    private static final long serialVersionUID = -3980863425685185211L;

    @ConfigProperty(configName = "annotation.properties", propertyName = "Service.id", type = Integer.class)
    private Integer id;

    @ConfigProperty(configName = "annotation.properties", propertyName = "Service.name", type = String.class)
    private String nameService;
    private Guest guest;
    private Float price;
    public static final String ENTITY_TOKEN = "Service";

    public UsedService(String nameService, Float price) {
        this.nameService = nameService;
        this.price = price;
    }

    public UsedService() {
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
