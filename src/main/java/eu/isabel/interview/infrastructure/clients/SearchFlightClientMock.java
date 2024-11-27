package eu.isabel.interview.infrastructure.clients;

import eu.isabel.interview.application.clients.SearchFlightClient;
import eu.isabel.interview.domain.models.Flight;

import java.util.List;

public final class SearchFlightClientMock {

    public static SearchFlightClient init(final List<Flight> flights) {
        return (from, to, date) -> flights;
    }

}
