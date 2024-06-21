package com.kodilla.spring.calculator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CalculatorTestSuite {

    @Autowired
    private Calculator calculator;

    @Test
    public void testCalculations() {
        //Given

        //When
        double addResult = calculator.add(5, 5);
        double subResult = calculator.sub(10, 5);
        double mulResult = calculator.mul(3, 3);
        double divResult = calculator.div(15, 3);

        //Then
        assertEquals(10, addResult);
        assertEquals(5, subResult);
        assertEquals(9, mulResult);
        assertEquals(5, divResult);
    }
}
