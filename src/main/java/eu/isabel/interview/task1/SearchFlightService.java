package eu.isabel.interview.task1;


import java.time.LocalDate;
import java.util.List;

/**
 * This represents the main API. `search` is called whenever a user press the "Search" button on the website.
 */
@FunctionalInterface
public interface SearchFlightService {

    SearchResult search(Airport from, Airport to, LocalDate date);

    class SearchFlightServiceFactory {

        /**
         * 1. Implement `fromTwoClients` which creates a `SearchFlightService` by combining the results from two
         *    `SearchFlightClient`. For example, imagine we fetch flight data from Swissair and lastminute.com.
         *    Please order the aggregated flights using the "best" ordering strategy (see `SearchResult`).
         *
         * 2. Several clients can return data for the same flight. For example, if we combine data
         *    from British Airways and lastminute.com, lastminute.com may include flights from British Airways.
         *    Update `fromTwoClients` so that if we get two or more flights with the same `flightId`,
         *    `SearchFlightService` selects the flight with the lowest `unitPrice` and discards the other ones.
         *
         * 3. A client may occasionally throw an exception. `fromTwoClients` should
         *    handle the error gracefully, for example log a message and ignore the error.
         *    In other words, `fromTwoClients` should consider that a client which throws an exception
         *    is the same as a client which returns an empty list.
         *
         * 5. Each client's search request is executed sequentially - one after another.
         *    Currently, we only send the request to client 2 after we have received the response from client 1.
         *    Instead, it would be better to send both search requests concurrently:
         */
        public static SearchFlightService fromTwoClients(final SearchFlightClient client1,
            final SearchFlightClient client2) {
            return (from, to, date) -> null; // TODO
        }

        /**
         * 4. Implement `fromClients` which behaves like `fromTwoClients` but it takes a list of `SearchFlightClient`.
         *    Note: You can use a recursion/loop/reduce to call all the clients and combine their results.
         *    Note: We can assume `clients` to contain less than 100 elements.
         *
         * Bonus:
         *      Implement the concurrent approach for 'fromClients'.
         *      `fromClients` waits for the results from every single client. This means that
         *      if one client is extremely slow, it will slow down the overall request.
         *      Implement a timeout per client so that the service doesn't spend more than
         *      500 milliseconds per client.
         */
        public static SearchFlightService fromClients(final List<SearchFlightClient> clients) {
            return (from, to, date) -> null; // TODO
        }
    }

}
