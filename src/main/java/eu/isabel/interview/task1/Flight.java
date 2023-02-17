package eu.isabel.interview.task1;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Comparator;

public final class Flight {

    /**
     * TODO
     *    Order by number of stops (0, 1, 2, ...) and then by price.
     *    For example, sorting the following flights
     *    flight A: 2 stops, $ 100
     *    flight B: 0 stop , $ 120
     *    flight C: 1 stop , $  50
     *    flight D: 0 stop , $  80
     *    produces: flight D, flight B, flight C, flight A
     */
    public static final Comparator<Flight> bestOrdering = null;

    private final String flightId; // unique id per flight
    private final String airline;
    private final Airport from;
    private final Airport to;
    private final Instant departureAt;
    private final Duration duration;
    private final Integer numberOfStops; // 0 for a direct flight
    private final Double unitPrice; // in euros
    private final String redirectLink;

    public Flight(String flightId, String airline, Airport from, Airport to, Instant departureAt,
        Duration duration, Integer numberOfStops, Double unitPrice, String redirectLink) {
        this.flightId = flightId;
        this.airline = airline;
        this.from = from;
        this.to = to;
        this.departureAt = departureAt;
        this.duration = duration;
        this.numberOfStops = numberOfStops;
        this.unitPrice = unitPrice;
        this.redirectLink = redirectLink;
    }

    public LocalDate departureDate() {
        return departureAt.atZone(from.getTimeZone()).toLocalDate();
    }

    public String getFlightId() {
        return flightId;
    }

    public String getAirline() {
        return airline;
    }

    public Airport getFrom() {
        return from;
    }

    public Airport getTo() {
        return to;
    }

    public Instant getDepartureAt() {
        return departureAt;
    }

    public Duration getDuration() {
        return duration;
    }

    public Integer getNumberOfStops() {
        return numberOfStops;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public String getRedirectLink() {
        return redirectLink;
    }

}
