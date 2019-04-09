package com.example.studyjams2018.entity;

public class Product {
    private String name;
    private int price;
    private int photoId;
    private int amount;

    public Product(String name, int price, int photoId, int amount) {
        this.name = name;
        this.price = price;
        this.photoId = photoId;
        this.amount = amount;
    }

    public Product(String name, int price, int photoId) {
        this(name, price, photoId, 0);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPhotoId() {
        return photoId;
    }

    public void setPhotoId(int photoId) {
        this.photoId = photoId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}