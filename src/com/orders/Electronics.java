package com.orders;
import lombok.Builder;

@Builder
public class Electronics extends Product {
    private final String brand;

    public Electronics(String name, double price, String brand) {
        super(name, price);
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    @Override
    public String toString() {
        return super.toString() + ", brand='" + brand + "'";
    }
}
