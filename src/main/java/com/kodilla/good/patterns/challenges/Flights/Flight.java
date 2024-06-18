package com.kodilla.good.patterns.challenges.Flights;

import java.util.Objects;

import java.util.Objects;

public class Flight {
    private final String departureCity;
    private final String arrivalCity;
    private final String layoverCity;

    public Flight(String departureCity, String arrivalCity) {
        this(departureCity, null, arrivalCity);
    }

    public Flight(String departureCity, String layoverCity, String arrivalCity) {
        this.departureCity = departureCity;
        this.layoverCity = layoverCity;
        this.arrivalCity = arrivalCity;
    }

    public String getDepartureCity() {
        return departureCity;
    }

    public String getArrivalCity() {
        return arrivalCity;
    }

    public String getLayoverCity() {
        return layoverCity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return Objects.equals(departureCity, flight.departureCity) &&
                Objects.equals(arrivalCity, flight.arrivalCity) &&
                Objects.equals(layoverCity, flight.layoverCity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(departureCity, arrivalCity, layoverCity);
    }

    @Override
    public String toString() {
        return "Flight{" +
                "departureCity='" + departureCity + '\'' +
                ", arrivalCity='" + arrivalCity + '\'' +
                (layoverCity != null ? ", layoverCity='" + layoverCity + '\'' : "") +
                '}';
    }
}