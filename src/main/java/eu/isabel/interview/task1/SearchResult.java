package eu.isabel.interview.task1;

import java.util.List;
import java.util.Optional;

/**
 * `flights` must be ordered using `Flight.bestOrdering`
 */
public final class SearchResult {

    private final List<Flight> flights;

    public SearchResult(List<Flight> flights) {
        this.flights = flights;
    }

    public Optional<Flight> cheapest() {
        return Optional.empty(); // TODO
    }

    public Optional<Flight> fastest() {
        return Optional.empty(); // TODO
    }

    public Optional<Flight> best() {
        return Optional.empty(); // TODO
    }

    public List<Flight> getFlights() {
        return flights;
    }
}
