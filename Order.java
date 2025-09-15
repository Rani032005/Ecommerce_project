package com.ecommerce.model;

import java.util.List;

public class Order {
    private int id;
    private int userId;
    private double totalAmount;
    private String status;
    private List<OrderItem> items;

    // Constructor
    public Order(int userId, double totalAmount, List<OrderItem> items) {
        this.userId = userId;
        this.totalAmount = totalAmount;
        this.items = items;
        this.status = "Placed";
    }

    // Empty constructor (if needed)
    public Order() {}

    // Getters & Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }
}
