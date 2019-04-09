package com.example.studyjams2018.entity;

public class Product {
    private String name;
    private int price;
    private int photoId;

    public Product(String name, int price, int photoId) {
        this.name = name;
        this.price = price;
        this.photoId = photoId;
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
}