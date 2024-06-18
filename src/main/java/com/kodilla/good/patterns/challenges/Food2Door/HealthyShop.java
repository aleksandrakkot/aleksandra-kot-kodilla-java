package com.kodilla.good.patterns.challenges.Food2Door;

public class HealthyShop implements Supplier {
    @Override
    public boolean process(String product, int quantity) {
        System.out.println("Processing order in HealthyShop for " + quantity + " units of " + product);

        if (quantity > 0 && product != null && !product.isEmpty() && isHealthyProduct(product)) {
            System.out.println("Order processed successfully by HealthyShop");
            return true;
        } else {
            System.out.println("Order processing failed by HealthyShop");
            return false;
        }
    }

    private boolean isHealthyProduct(String product) {
        return product.toLowerCase().contains("healthy");
    }
}