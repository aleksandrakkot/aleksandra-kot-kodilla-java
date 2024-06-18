package com.kodilla.good.patterns.challenges.Flights;

public class ArrivalCityCriteria implements SearchCriteria {
    private final String arrivalCity;

    public ArrivalCityCriteria(String arrivalCity) {
        this.arrivalCity = arrivalCity;
    }

    @Override
    public boolean matches(Flight flight) {
        return flight.getArrivalCity().equals(arrivalCity);
    }
}
