package com.kodilla.good.patterns.challenges;

public class GameOrderService implements ProductOrderService {
    public boolean order(User user, Product product) {
        System.out.println("Ordering game: " + product.getName() + " for user: " + user.getName());
        return true;
    }
}
