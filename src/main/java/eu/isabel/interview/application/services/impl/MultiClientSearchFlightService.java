package eu.isabel.interview.application.services.impl;

import eu.isabel.interview.application.clients.SearchFlightClient;
import eu.isabel.interview.application.services.SearchFlightService;
import eu.isabel.interview.domain.models.Airport;
import eu.isabel.interview.domain.models.Flight;
import eu.isabel.interview.domain.models.SearchResult;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * A SearchFlightService to search for Flights using multiple {@link eu.isabel.interview.application.clients.SearchFlightClient}s
 */
public class MultiClientSearchFlightService implements SearchFlightService {

    private final List<SearchFlightClient> clients;

    private static final Logger logger = Logger.getLogger(MultiClientSearchFlightService.class.getName());

    protected MultiClientSearchFlightService(SearchFlightClient ...clients) {
        if (null == clients || clients.length == 0) {
            throw new IllegalArgumentException("At least one client must be provided.");
        }
        this.clients = List.of(clients);
    }

    @Override
    public SearchResult search(Airport from, Airport to, LocalDate date) {
        // TODO Use CompletableFuture to handle SearchFlightClient timeouts
        Collection<Flight> flights = clients.parallelStream()
                .flatMap(client -> {
                    try {
                        return client.search(from, to, date).stream();
                    } catch (Exception e) {
                        logger.log(Level.WARNING, "Error: Client failed to resolve", e);
                        System.out.printf("Error: Client %s failed to resolve.%n", client.getClass().getName());

                        return Stream.empty();
                    }
                })
                .collect(Collectors.toMap(
                        Flight::flightId,
                        flight -> flight,
                        // TODO: Extract the merge strategy to allow other criteria
                        (flight1, flight2) -> flight1.unitPrice() < flight2.unitPrice() ? flight1 : flight2
                )).values();

        return new SearchResult(new ArrayList<>(flights), Flight.bestOrdering);
    }

}
