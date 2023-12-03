package com.model;

import java.sql.Blob;

public class Product {
    private int code;
    private String name;
    private double price;
    private int stock;
    private String description;
    private String category;
    private Blob image;
    private Blob image2;
    private Blob image3;
    private Blob image4;
    private int qtd;

    public Product() {
        super();
    }

    public Product(int code, String name, double price, int stock, String description, String category, Blob image, Blob image2, Blob image3, Blob image4) {
        super();

        this.code = code;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.description = description;
        this.category = category;
        this.image = image;
        this.image2 = image2;
        this.image3 = image3;
        this.image4 = image4;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Blob getImage() {
        return image;
    }

    public void setImage(Blob image) {
        this.image = image;
    }

    public Blob getImage2() {
        return image2;
    }

    public void setImage2(Blob image2) {
        this.image2 = image2;
    }

    public Blob getImage3() {
        return image3;
    }

    public void setImage3(Blob image3) {
        this.image3 = image3;
    }

    public Blob getImage4() {
        return image4;
    }

    public void setImage4(Blob image4) {
        this.image4 = image4;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }
}
