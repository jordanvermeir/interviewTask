package eu.isabel.interview.domain.models;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Comparator;

/**
 * @param flightId unique id per flight
 * @param numberOfStops 0 for a direct flight
 * @param unitPrice in euros
 */
public record Flight(String flightId, String airline, Airport from, Airport to, Instant departureAt, Duration duration,
                     Integer numberOfStops, Double unitPrice, String redirectLink) {

    // FIXME: Move this out of the Flight class.
    //        We shouldn't need to update the Flight class when
    //        introducing new sorting strategies
    /**
     * Order {@link Flight}s by number of stops (0, 1, 2, ...) and then by price.
     */
    public static final Comparator<Flight> bestOrdering = Comparator
            .comparingInt(Flight::numberOfStops)
            .thenComparing(Flight::unitPrice);

    public LocalDate departureDate() {
        return departureAt.atZone(from.timeZone()).toLocalDate();
    }

}
