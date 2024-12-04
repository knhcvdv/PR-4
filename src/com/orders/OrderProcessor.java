package com.orders;

import com.orders.exceptions.OrderProcessingException;

import java.util.List;
import java.util.function.Consumer;

public class OrderProcessor<T extends Product> {

    public void processOrders(List<T> orders, Consumer<T> action) throws OrderProcessingException {
        if (orders == null || orders.isEmpty()) {
            throw new OrderProcessingException("Список замовлень пустий!");
        }

        orders.forEach(action);
    }
}
