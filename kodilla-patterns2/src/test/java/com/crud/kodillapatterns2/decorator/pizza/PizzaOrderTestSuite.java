package com.crud.kodillapatterns2.decorator.pizza;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PizzaOrderTestSuite {

    @Test
    void testBasicPizzaOrder() {
        // Given
        PizzaOrder pizzaOrder = new BasicPizza();

        // When
        BigDecimal cost = pizzaOrder.getCost();
        String description = pizzaOrder.getDescription();

        // Then
        assertEquals(new BigDecimal(15.00), cost);
        assertEquals("Pizza with tomato sauce and cheese", description);
    }

    @Test
    void testPizzaWithExtraCheese() {
        // Given
        PizzaOrder pizzaOrder = new BasicPizza();
        pizzaOrder = new CheeseDecorator(pizzaOrder);

        // When
        BigDecimal cost = pizzaOrder.getCost();
        String description = pizzaOrder.getDescription();

        // Then
        assertEquals(new BigDecimal(18.00), cost);
        assertEquals("Pizza with tomato sauce and cheese + extra cheese", description);
    }

    @Test
    void testPizzaWithOlivesAndMushrooms() {
        // Given
        PizzaOrder pizzaOrder = new BasicPizza();
        pizzaOrder = new OlivesDecorator(pizzaOrder);
        pizzaOrder = new MushroomsDecorator(pizzaOrder);

        // When
        BigDecimal cost = pizzaOrder.getCost();
        String description = pizzaOrder.getDescription();

        // Then
        assertEquals(new BigDecimal(21.00), cost);
        assertEquals("Pizza with tomato sauce and cheese + olives + mushrooms", description);
    }

    @Test
    void testPizzaWithMultipleDecorators() {
        // Given
        PizzaOrder pizzaOrder = new BasicPizza();
        pizzaOrder = new CheeseDecorator(pizzaOrder);
        pizzaOrder = new OlivesDecorator(pizzaOrder);
        pizzaOrder = new MushroomsDecorator(pizzaOrder);

        // When
        BigDecimal cost = pizzaOrder.getCost();
        String description = pizzaOrder.getDescription();

        // Then
        assertEquals(new BigDecimal(24.00), cost);
        assertEquals("Pizza with tomato sauce and cheese + extra cheese + olives + mushrooms", description);
    }
}
