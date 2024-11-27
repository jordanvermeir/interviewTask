package eu.isabel.interview.application.services;


import eu.isabel.interview.application.clients.SearchFlightClient;
import eu.isabel.interview.domain.models.Airport;
import eu.isabel.interview.domain.models.Flight;
import eu.isabel.interview.domain.models.SearchResult;

import java.time.LocalDate;
import java.util.List;

/**
 * This represents the main API. {@link SearchFlightService#search(Airport, Airport, LocalDate)} is called whenever a
 * user press the "Search" button on the website.
 */
@FunctionalInterface
public interface SearchFlightService {

    SearchResult search(Airport from, Airport to, LocalDate date);

    final class SearchFlightServiceFactory {

        /**
         * TODO 1.
         *    Implement {@link SearchFlightServiceFactory#fromTwoClients(SearchFlightClient, SearchFlightClient)} which
         *    creates a {@link SearchFlightService} by combining the results from two {@link SearchFlightClient}. For
         *    example, imagine we fetch flight data from Swissair and lastminute.com.
         *    Please order the aggregated flights using the "best" ordering strategy (see {@link SearchResult}).
         * <p>
         *
         * TODO 2.
         *    Several clients can return data for the same flight. For example, if we combine data
         *    from British Airways and lastminute.com, lastminute.com may include flights from British Airways.
         *    Update {@link SearchFlightServiceFactory#fromTwoClients(SearchFlightClient, SearchFlightClient)} so that
         *    if we get two or more flights with the same {@link Flight#flightId()}, {@link SearchFlightService}
         *    selects the flight with the lowest {@link Flight#unitPrice()} and discards the other ones.
         * <p>
         *
         * TODO 3.
         *    A client may occasionally throw an exception.
         *    {@link SearchFlightServiceFactory#fromTwoClients(SearchFlightClient, SearchFlightClient)} should
         *    handle the error gracefully, for example log a message and ignore the error.
         *    In other words, `fromTwoClients` should consider that a client which throws an exception
         *    is the same as a client which returns an empty list.
         * <p>
         *
         * TODO 5.
         *    Each client's search request is executed sequentially - one after another.
         *    Currently, we only send the request to client 2 after we have received the response from client 1.
         *    Instead, it would be better to send both search requests concurrently:
         */
        public static SearchFlightService fromTwoClients(final SearchFlightClient client1,
            final SearchFlightClient client2) {
            return (from, to, date) -> null;
        }

        /**
         * TODO 4.
         *    Implement {@link SearchFlightServiceFactory#fromClients(List)} which behaves like
         *    {@link SearchFlightServiceFactory#fromTwoClients(SearchFlightClient, SearchFlightClient)} but it takes a
         *    list of {@link SearchFlightClient}.
         *    Note: You can use a recursion/loop/reduce to call all the clients and combine their results.
         *    Note: We can assume {@code clients} to contain less than 100 elements.
         * <p>
         *
         * TODO Bonus:
         *    Implement the concurrent approach for {@link SearchFlightServiceFactory#fromClients(List)}.
         *    {@link SearchFlightServiceFactory#fromClients(List)} waits for the results from every single client. This
         *    means that if one client is extremely slow, it will slow down the overall request.
         *    Implement a timeout per client so that the service doesn't spend more than 500 milliseconds per client.
         */
        public static SearchFlightService fromClients(final List<SearchFlightClient> clients) {
            return (from, to, date) -> null;
        }
    }

}
