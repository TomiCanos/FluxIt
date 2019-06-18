package com.example.fluxitdemo.model;

// Creating a POJO to parse the data from the API
public class Product {
    private String title;
    private String id;
    private String price;

    public Product(String title, String id, String price) {
        this.title = title;
        this.id = id;
        this.price = price;
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

}
