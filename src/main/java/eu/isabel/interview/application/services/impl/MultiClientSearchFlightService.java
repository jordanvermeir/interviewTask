package eu.isabel.interview.application.services.impl;

import eu.isabel.interview.application.clients.SearchFlightClient;
import eu.isabel.interview.application.services.SearchFlightService;
import eu.isabel.interview.domain.models.Airport;
import eu.isabel.interview.domain.models.SearchResult;

import java.time.LocalDate;
import java.util.List;

/**
 * A SearchFlightService to search for Flights using multiple {@link eu.isabel.interview.application.clients.SearchFlightClient}s
 */
public class MultiClientSearchFlightService implements SearchFlightService {

    private List<SearchFlightClient> clients;

    public MultiClientSearchFlightService(SearchFlightClient ...clients) {
        this.clients = List.of(clients);
    }

    @Override
    public SearchResult search(Airport from, Airport to, LocalDate date) {
        return null;
    }

}
