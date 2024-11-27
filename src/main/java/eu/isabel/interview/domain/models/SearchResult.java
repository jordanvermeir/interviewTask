package eu.isabel.interview.domain.models;

import java.util.List;
import java.util.Optional;

/**
 * {@link SearchResult#flights} must be ordered using {@link Flight#bestOrdering}.
 */
public record SearchResult(List<Flight> flights) {

    public Optional<Flight> cheapest() {
        return Optional.empty(); // TODO
    }

    public Optional<Flight> fastest() {
        return Optional.empty(); // TODO
    }

    public Optional<Flight> best() {
        return Optional.empty(); // TODO
    }
}