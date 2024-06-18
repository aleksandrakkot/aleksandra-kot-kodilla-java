package com.kodilla.good.patterns.challenges.Food2Door;

public class Application {
    public static void main(String[] args) {
        Supplier extraFoodShop = new ExtraFoodShop();
        Supplier healthyShop = new HealthyShop();
        Supplier glutenFreeShop = new GlutenFreeShop();

        OrderProcessor orderProcessor = new OrderProcessor();

        System.out.println("ExtraFoodShop: " + orderProcessor.processOrder(extraFoodShop, "Apples", 10));
        System.out.println("HealthyShop: " + orderProcessor.processOrder(healthyShop, "Healthy Bananas", 5));
        System.out.println("GlutenFreeShop: " + orderProcessor.processOrder(glutenFreeShop, "Gluten-Free Bread", 2));
        System.out.println("GlutenFreeShop: " + orderProcessor.processOrder(glutenFreeShop, "Normal Bread", 2)); // Example of failed order
    }
}