package com.example.fluxitdemo.model;

// Creating a POJO to parse the data from the API
public class Product {
    private String title;
    private String id;
    private String price;
    private String condition;
    private String thumbnail;

    public Product(String title, String id, String price, String condition, String thumbnail) {
        this.title = title;
        this.id = id;
        this.price = price;
        this.condition = condition;
        this.thumbnail = thumbnail;
    }

    public String getTitle() {
        return title;
    }

    public String getId() {
        return id;
    }

    public String getPrice() {
        return price;
    }

    public String getCondition() {
        return condition;
    }

    public String getThumbnail() {
        return thumbnail;
    }
}
