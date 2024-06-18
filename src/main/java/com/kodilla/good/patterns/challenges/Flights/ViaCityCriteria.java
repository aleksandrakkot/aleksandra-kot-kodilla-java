package com.kodilla.good.patterns.challenges.Flights;

public class ViaCityCriteria implements SearchCriteria {
    private final String departureCity;
    private final String layoverCity;
    private final String arrivalCity;

    public ViaCityCriteria(String departureCity, String layoverCity, String arrivalCity) {
        this.departureCity = departureCity;
        this.layoverCity = layoverCity;
        this.arrivalCity = arrivalCity;
    }

    @Override
    public boolean matches(Flight flight) {
        return flight.getDepartureCity().equals(departureCity) &&
                flight.getLayoverCity() != null &&
                flight.getLayoverCity().equals(layoverCity) &&
                flight.getArrivalCity().equals(arrivalCity);
    }
}