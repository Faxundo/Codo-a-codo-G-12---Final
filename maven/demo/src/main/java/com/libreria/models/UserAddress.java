package com.libreria.models;
public class UserAddress {
    private int id;
    private User user_id;
    private String country;
    private String city;
    private String postal_code;
    private String address;
    
    public UserAddress(int id, User user_id, String country, String city, String postal_code, String address) {
        this.id = id;
        this.user_id = user_id;
        this.country = country;
        this.city = city;
        this.postal_code = postal_code;
        this.address = address;
    }
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public User getUser_id() {
        return user_id;
    }
    public void setUser_id(User user_id) {
        this.user_id = user_id;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getPostal_code() {
        return postal_code;
    }
    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }


}
