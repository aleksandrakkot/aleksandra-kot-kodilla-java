package com.kodilla.patterns2.observer.homework;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class TaskQueueTestSuite {

    @Test
    public void testUpdate() {
        // Given
        TaskQueue student1Queue = new TaskQueue("John Doe");
        TaskQueue student2Queue = new TaskQueue("Jane Smith");
        TaskQueue student3Queue = new TaskQueue("Tom White");

        Mentor mentor1 = new Mentor("Mentor A");
        Mentor mentor2 = new Mentor("Mentor B");

        student1Queue.registerObserver(mentor1);
        student2Queue.registerObserver(mentor1);
        student3Queue.registerObserver(mentor2);

        // When
        student1Queue.addTask("Task 1");
        student1Queue.addTask("Task 2");
        student2Queue.addTask("Task 1");
        student3Queue.addTask("Task 1");

        // Then
        assertEquals(3, mentor1.getUpdateCount());  // Mentor A should have 3 tasks to check
        assertEquals(1, mentor2.getUpdateCount());  // Mentor B should have 1 task to check
    }
}