package com.storage;

import com.orders.Product;

import java.util.ArrayList;
import java.util.List;

public class OrderStorage {
    private final List<Product> storage = new ArrayList<>();

    public synchronized void addOrder(Product order) {
        storage.add(order);
    }

    public synchronized List<Product> getAllOrders() {
        return new ArrayList<>(storage);
    }
}
