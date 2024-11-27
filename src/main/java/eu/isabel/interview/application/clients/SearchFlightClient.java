package eu.isabel.interview.application.clients;

import eu.isabel.interview.domain.models.Airport;
import eu.isabel.interview.domain.models.Flight;

import java.time.LocalDate;
import java.util.List;

/**
 * This interface represents the API used to contact a flight data provider such as:
 * British Airways, lastminute.com or Swissair
 * <p>
 * We assume this API is standard and all data providers use the same interface.
 * <p>
 * For example, a real implementation of {@link SearchFlightClient} could use an HTTP client.
 */
@FunctionalInterface
public interface SearchFlightClient {

    List<Flight> search(Airport from, Airport to, LocalDate date);

}


