package com.orders;

import lombok.Builder;

@Builder
public class Clothing extends Product {
    private final String size;

    public Clothing(String name, double price, String size) {
        super(name, price);
        this.size = size;
    }

    public String getSize() {
        return size;
    }

    @Override
    public String toString() {
        return super.toString() + ", size='" + size + "'";
    }
}
