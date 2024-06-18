package com.kodilla.good.patterns.challenges.Flights;


@FunctionalInterface
public interface SearchCriteria {
    boolean matches(Flight flight);
}