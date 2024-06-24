package com.kodilla.patterns.factory.tasks;

import com.kodilla.patterns.factory.Circle;
import com.kodilla.patterns.factory.Rectangle;
import com.kodilla.patterns.factory.Shape;
import com.kodilla.patterns.factory.Square;

public final class TaskFactory {
    public static final String SHOPPING = "SHOPPING";
    public static final String PAINTING = "PAINTING";
    public static final String DRIVING = "DRIVING";

    public final Task createTask(final String taskClass) {
        return switch (taskClass) {
            case SHOPPING -> new ShoppingTask("Buy groceries", "Milk", 2);
            case PAINTING -> new PaintingTask("Paint wall", "Red", "Living Room wall");
            case DRIVING -> new DrivingTask("Drive to the office", "Office", "Car");
            default -> null;
        };
    }
}