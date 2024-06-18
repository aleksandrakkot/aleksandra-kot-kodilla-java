package com.kodilla.good.patterns.challenges.Flights;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FlightService {
    private final List<Flight> flights = new ArrayList<>();

    public void addFlight(Flight flight) {
        flights.add(flight);
    }

    public List<Flight> findFlights(SearchCriteria criteria) {
        return flights.stream()
                .filter(criteria::matches)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        FlightService flightService = new FlightService();

        flightService.addFlight(new Flight("GDANSK", "WROCLAW"));
        flightService.addFlight(new Flight("GDANSK", "KRAKOW", "WROCLAW"));
        flightService.addFlight(new Flight("GDANSK", "POZNAN"));
        flightService.addFlight(new Flight("WARSZAWA", "WROCLAW"));

        System.out.println("Loty z GDANSK:");
        flightService.findFlights(new DepartureCityCriteria("GDANSK")).forEach(System.out::println);

        System.out.println("\nLoty do WROCLAW:");
        flightService.findFlights(new ArrivalCityCriteria("WROCLAW")).forEach(System.out::println);

        System.out.println("\nLoty z GDANSK przez KRAKOW do WROCLAW:");
        flightService.findFlights(new ViaCityCriteria("GDANSK", "KRAKOW", "WROCLAW")).forEach(System.out::println);
    }
}