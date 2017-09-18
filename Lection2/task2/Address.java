public class Address {
    private String street;
    private Integer houseNumber;
    private Integer appartmentNumber;
    private Integer phone;

    public Address() {
        System.out.println(Address.class.getName());
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(Integer houseNumber) {
        this.houseNumber = houseNumber;
    }

    public Integer getAppartmentNumber() {
        return appartmentNumber;
    }

    public void setAppartmentNumber(Integer appartmentNumber) {
        this.appartmentNumber = appartmentNumber;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }
}