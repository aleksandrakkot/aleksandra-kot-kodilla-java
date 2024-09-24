package com.crud.kodillapatterns2.decorator.pizza;
import java.math.BigDecimal;

public class BasicPizza implements PizzaOrder {
    @Override
    public BigDecimal getCost() {
        return new BigDecimal(15.00);
    }

    @Override
    public String getDescription() {
        return "Pizza with tomato sauce and cheese";
    }
}