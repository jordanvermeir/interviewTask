package eu.isabel.interview.domain.models;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * {@link SearchResult#flights} must be ordered using {@link Flight#bestOrdering}.
 */
public record SearchResult(List<Flight> flights) {

    public SearchResult(List<Flight> flights, Comparator<Flight> sortingStrategy) {
        this(flights.stream()
                .sorted(sortingStrategy)
                .toList()
        );
    }

    public Optional<Flight> cheapest() {
        return Optional.empty(); // TODO
    }

    public Optional<Flight> fastest() {
        return Optional.empty(); // TODO
    }

    public Optional<Flight> best() {
        return this.flights.stream()
                .sorted(Flight.bestOrdering)
                .findFirst();
    }
}