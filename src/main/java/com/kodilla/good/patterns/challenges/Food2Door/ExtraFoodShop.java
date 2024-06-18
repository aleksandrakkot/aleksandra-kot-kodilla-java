package com.kodilla.good.patterns.challenges.Food2Door;

public class ExtraFoodShop implements Supplier {
    @Override
    public boolean process(String product, int quantity) {
        System.out.println("Processing order in ExtraFoodShop for " + quantity + " units of " + product);

        if (quantity > 0 && product != null && !product.isEmpty()) {
            System.out.println("Order processed successfully by ExtraFoodShop");
            return true;
        } else {
            System.out.println("Order processing failed by ExtraFoodShop");
            return false;
        }
    }
}
