package com.crud.kodillapatterns2.decorator.pizza;

import java.math.BigDecimal;

public class OlivesDecorator extends AbstractPizzaDecorator {
    public OlivesDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(2));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + olives";
    }
}