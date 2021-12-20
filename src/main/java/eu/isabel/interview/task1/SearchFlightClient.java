package eu.isabel.interview.task1;

import java.time.LocalDate;
import java.util.List;

/**
 * This interface represents the API used to contact a flight data provider such as:
 *  British Airways, lastminute.com or Swissair
 *
 *  We assume this API is standard and all data providers use the same interface.
 *
 *  For example, a real implementation of `SearchFlightClient` could use an HTTP client.
 */
@FunctionalInterface
public interface SearchFlightClient {

    List<Flight> search(Airport from, Airport to, LocalDate date);

    class SearchFlightClientMock {

        public static SearchFlightClient init(final List<Flight> flights) {
            return (from, to, date) -> flights;
        }
    }

}


