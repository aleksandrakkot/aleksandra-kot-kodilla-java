package com.kodilla.patterns2.observer.homework;

public class Mentor implements Observer {
    private final String name;
    private int updateCount;

    public Mentor(String name) {
        this.name = name;
        this.updateCount = 0;
    }

    @Override
    public void update(TaskQueue taskQueue) {
        System.out.println("Mentor " + name + ": New task in " + taskQueue.getStudentName() + "'s queue. Total tasks to check: " + taskQueue.getTasks().size());
        updateCount++;
    }

    public int getUpdateCount() {
        return updateCount;
    }
}