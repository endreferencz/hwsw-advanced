package com.epam.statistics;

public class Transaction {
    private String street;
    private String city;
    private String state;
    private int beds;
    private int baths;
    private int floorArea;
    private String type;
    private int price;

    public Transaction() {
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getBeds() {
        return beds;
    }

    public void setBeds(int beds) {
        this.beds = beds;
    }

    public int getBaths() {
        return baths;
    }

    public void setBaths(int baths) {
        this.baths = baths;
    }

    public int getFloorArea() {
        return floorArea;
    }

    public void setFloorArea(int floorArea) {
        this.floorArea = floorArea;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Transaction [street=" + street + ", city=" + city + ", state=" + state + ", beds=" + beds + ", baths=" + baths + ", floorArea="
                + floorArea + ", type=" + type + ", price=" + price + "]";
    }

}
