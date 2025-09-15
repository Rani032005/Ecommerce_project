package com.ecommerce.model;

public class CartItem {
    private String name;
    private double price;
    private int quantity;

    // constructor
    public CartItem(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    // getters
    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
}