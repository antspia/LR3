package org.example;

import java.util.List;

public class Order {
    private int orderId;
    private List<Product> products;
    private String status;

    public Order(List<Product> products) {
        this.products = products;
        this.status = "CREATED";
    }

    public double calculateTotal() {
        double total = 0;
        for(Product p : products) {
            total += p.getPrice();
        }
        return total;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public String getStatus() {
        return status;
    }

    public int getId() {
        return orderId;
    }
}
