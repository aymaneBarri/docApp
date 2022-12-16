package com.example.docapp;

import javafx.scene.image.Image;

import java.time.LocalDateTime;
import java.util.Date;

public class Product {
    private int id;
    private String brand;
    private String name;
    private double price;
    private String image;
    private LocalDateTime register;

    public Product(int id, String brand, String name, Double price, String image, LocalDateTime register) {
        this.id = id;
        this.brand = brand;
        this.name = name;
        this.price = price;
        this.image = image;
        this.register = register;
    }

    public int getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getImage() {
        return image;
    }

    public LocalDateTime getRegister() {
        return register;
    }
}
