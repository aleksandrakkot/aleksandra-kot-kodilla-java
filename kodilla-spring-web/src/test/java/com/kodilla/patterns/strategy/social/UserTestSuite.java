package com.kodilla.patterns.strategy.social;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTestSuite {

    @Test
    void testDefaultSharingStrategies() {
        // Given
        User millenial = new Millenials("John Doe");
        User yGen = new YGeneration("Jane Smith");
        User zGen = new ZGeneration("Zack Taylor");

        // When
        String millenialShare = millenial.sharePost();
        String yGenShare = yGen.sharePost();
        String zGenShare = zGen.sharePost();

        // Then
        assertEquals("Facebook", millenialShare);
        assertEquals("Twitter", yGenShare);
        assertEquals("Snapchat", zGenShare);
    }

    @Test
    void testIndividualSharingStrategy() {
        // Given
        User millenial = new Millenials("John Doe");

        // When
        millenial.setSocialPublisher(new TwitterPublisher());
        String millenialShare = millenial.sharePost();

        // Then
        assertEquals("Twitter", millenialShare);
    }
}