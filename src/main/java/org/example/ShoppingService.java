package org.example;

import java.util.HashMap;
import java.util.Map;

public class ShoppingService {
    private Map<Integer, Order> orders;
    private Cart cart;

    public ShoppingService() {
        orders = new HashMap<>();
        cart = new Cart();
    }

    public void addProductToCart(Product product) {
        cart.addProduct(product);
    }

    public Order createOrder(Cart cart) {
        Order order = new Order(this.cart.getProducts());
        orders.put(order.getOrderId(), order);
        return order;
    }

    public String getOrderStatus(int orderId) {
        return orders.get(orderId).getStatus();
    }
}
