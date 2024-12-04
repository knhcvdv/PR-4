package com.threads;

import com.orders.Product;
import com.storage.OrderStorage;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class OrderThreadManager {

    private final ExecutorService executor = Executors.newFixedThreadPool(4);

    public void processOrdersConcurrently(List<? extends Product> orders, OrderStorage storage) {
        orders.forEach(order -> executor.submit(() -> {
            System.out.println("Processing order: " + order);
            storage.addOrder(order);
        }));
    }

    public void shutdown() {
        executor.shutdown();
    }
}
