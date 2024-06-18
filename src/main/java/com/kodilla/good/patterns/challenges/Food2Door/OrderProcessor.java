package com.kodilla.good.patterns.challenges.Food2Door;

public class OrderProcessor {
    public boolean processOrder(Supplier supplier, String product, int quantity) {
        System.out.println("Starting order processing for " + product + " with quantity " + quantity);
        boolean result = supplier.process(product, quantity);
        if (result) {
            System.out.println("Order processing completed successfully.");
        } else {
            System.out.println("Order processing failed.");
        }
        return result;
    }
}