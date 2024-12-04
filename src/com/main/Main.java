package com.main;

import com.orders.Clothing;
import com.orders.Electronics;
import com.orders.OrderProcessor;
import com.orders.Product;
import com.storage.OrderStorage;
import com.threads.OrderThreadManager;
import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Faker faker = new Faker();
        OrderStorage storage = new OrderStorage();
        OrderThreadManager threadManager = new OrderThreadManager();

        // Створення списку замовлень
        List<Product> orders = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                orders.add(Clothing.builder()
                        .name(faker.commerce().productName())
                        .price(Double.parseDouble(faker.commerce().price()))
                        .size(faker.lorem().word())
                        .build());
            } else {
                orders.add(Electronics.builder()
                        .name(faker.commerce().productName())
                        .price(Double.parseDouble(faker.commerce().price()))
                        .brand(faker.company().name())
                        .build());
            }
        }

        // Обробка замовлень
        OrderProcessor<Product> processor = new OrderProcessor<>();
        try {
            processor.processOrders(orders, order -> System.out.println("Processed: " + order));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Обробка у багатопоточному режимі
        threadManager.processOrdersConcurrently(orders, storage);

        // Закриття потоків
        threadManager.shutdown();

        System.out.println("Збережені замовлення:");
        storage.getAllOrders().forEach(System.out::println);
    }
}
