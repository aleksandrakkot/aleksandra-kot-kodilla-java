package com.kodilla.good.patterns.challenges.Flights;

public class DepartureCityCriteria implements SearchCriteria {
    private final String departureCity;

    public DepartureCityCriteria(String departureCity) {
        this.departureCity = departureCity;
    }

    @Override
    public boolean matches(Flight flight) {
        return flight.getDepartureCity().equals(departureCity);
    }
}