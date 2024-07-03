package com.example.demo.model;

public class Product {
    private int id;
    private Category category_id;
    private String title;
    private String description;
    private float price;
    private String url;
    
    public Product(int id, Category category_id, String title, String description, float price, String url) {
        this.id = id;
        this.category_id = category_id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.url = url;
    }

    public Product(Category category_id, String title, String description, float price, String url) {
        this.category_id = category_id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.url = url;
    }

    public Product (){}

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Category getCategory_id() {
        return category_id;
    }
    public void setCategory_id(Category category_id) {
        this.category_id = category_id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        this.price = price;
    }

    public String getUrl () {
        return url;
    }

    public void setUrl (String url) {
        this.url = url;
    }
    
}
