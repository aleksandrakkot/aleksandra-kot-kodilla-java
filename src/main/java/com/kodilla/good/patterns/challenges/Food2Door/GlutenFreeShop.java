package com.kodilla.good.patterns.challenges.Food2Door;

public class GlutenFreeShop implements Supplier {
    @Override
    public boolean process(String product, int quantity) {
        System.out.println("Processing order in GlutenFreeShop for " + quantity + " units of " + product);

        if (quantity > 0 && product != null && !product.isEmpty() && isGlutenFree(product)) {
            System.out.println("Order processed successfully by GlutenFreeShop");
            return true;
        } else {
            System.out.println("Order processing failed by GlutenFreeShop");
            return false;
        }
    }

    private boolean isGlutenFree(String product) {
        return product.toLowerCase().contains("gluten-free");
    }
}