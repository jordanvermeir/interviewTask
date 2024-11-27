package eu.isabel.interview.application.services.impl;

import eu.isabel.interview.application.clients.SearchFlightClient;
import eu.isabel.interview.application.services.SearchFlightService;

public final class SearchFlightServiceFactory {

    /**
     * Get a {@link SearchFlightService} that aggregates results
     * from 2 {@link SearchFlightClient}s.
     *
     * @param client1 The first {@link SearchFlightClient}
     * @param client2 The second {@link SearchFlightClient}
     * @return The aggregated results from client1 and client2
     */
    public static SearchFlightService fromTwoClients(final SearchFlightClient client1,
                                                     final SearchFlightClient client2) {
        return new MultiClientSearchFlightService(client1, client2);
    }

    /**
     * Get a {@link SearchFlightService} that aggregates results
     * from multiple {@link SearchFlightClient}s.
     *
     * @param clients The to-be-aggregated {@link SearchFlightClient}s
     * @return The aggregated results from all the provided clients
     */
    public static SearchFlightService fromClients(final SearchFlightClient ...clients) {
        return new MultiClientSearchFlightService(clients);
    }
}
