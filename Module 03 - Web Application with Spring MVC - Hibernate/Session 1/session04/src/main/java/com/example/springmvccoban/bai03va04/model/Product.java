package com.example.springmvccoban.bai03va04.model;

public class Product {
    private long id;
    private String ProductName;
    private double price;
    private int stock ;
    private String description;

    public Product() {
    }

    public Product(long id, String productName, double price, int stock, String description) {
        this.id = id;
        ProductName = productName;
        this.price = price;
        this.stock = stock;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
