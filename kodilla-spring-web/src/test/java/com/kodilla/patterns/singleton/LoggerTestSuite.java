package com.kodilla.patterns.singleton;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoggerTestSuite {

    @Test
    void testGetLastLog() {
        // Given
        Logger logger = Logger.INSTANCE;
        logger.log("First log");

        // When
        String result = logger.getLastLog();

        // Then
        Assertions.assertEquals("First log", result);
    }

    @Test
    void testLog() {
        // Given
        Logger logger = Logger.INSTANCE;
        logger.log("Second log");

        // When
        String result = logger.getLastLog();

        // Then
        Assertions.assertEquals("Second log", result);
    }
}