package com.kodilla.patterns.builder.bigmac;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BigmacTestSuite {
    @Test
    void testBigmacBuilder() {
        // Given
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .bun("Sesame")
                .burgers(2)
                .sauce("Barbecue")
                .ingredient("Lettuce")
                .ingredient("Bacon")
                .ingredient("Onion")
                .build();

        // When
        String bun = bigmac.getBun();
        int burgers = bigmac.getBurgers();
        String sauce = bigmac.getSauce();
        List<String> ingredients = bigmac.getIngredients();

        // Then
        assertEquals("Sesame", bun);
        assertEquals(2, burgers);
        assertEquals("Barbecue", sauce);
        assertTrue(ingredients.contains("Lettuce"));
        assertTrue(ingredients.contains("Bacon"));
        assertTrue(ingredients.contains("Onion"));
        assertEquals(3, ingredients.size());
    }
}
