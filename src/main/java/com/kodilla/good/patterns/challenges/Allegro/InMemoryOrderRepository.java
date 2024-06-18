package com.kodilla.good.patterns.challenges.Allegro;

public class InMemoryOrderRepository implements OrderRepository {
    public void createOrder(User user, Product product) {
        System.out.println("Saving order for: " + user.getName() + " for product: " + product.getName());
    }
}