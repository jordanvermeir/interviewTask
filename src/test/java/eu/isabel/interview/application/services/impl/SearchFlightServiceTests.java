package eu.isabel.interview.application.services.impl;

import eu.isabel.interview.application.clients.SearchFlightClient;
import eu.isabel.interview.application.services.SearchFlightService;
import eu.isabel.interview.domain.models.Airport;
import eu.isabel.interview.domain.models.Flight;
import eu.isabel.interview.domain.models.SearchResult;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

import static eu.isabel.interview.domain.models.Airport.londonGatwick;
import static eu.isabel.interview.domain.models.Airport.parisOrly;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SearchFlightServiceTests {

    @Test
    void testSuccessfulSearchFromClients() {
        // Setup test data
        LocalDate from = LocalDate.of(2024, 11, 27);
        Instant departureTime = Instant.now();

        Flight flight1 = new Flight("1", "BA", parisOrly, londonGatwick, departureTime, Duration.ofMinutes(100), 0, 89.5, "");
        Flight flight1Cheaper = new Flight("1", "BA", parisOrly, londonGatwick, departureTime, Duration.ofMinutes(100), 0, 70.0, "");
        Flight flight2 = new Flight("2", "LH", parisOrly, londonGatwick, departureTime, Duration.ofMinutes(105), 0, 96.5, "");
        Flight flight3 = new Flight("3", "BA", parisOrly, londonGatwick, departureTime, Duration.ofMinutes(140), 1, 234.0, "");
        Flight flight4 = new Flight("4", "LH", parisOrly, londonGatwick, departureTime, Duration.ofMinutes(210), 2, 55.5, "");

        // Setup Mocks
        SearchFlightClient client1 = mock(SearchFlightClient.class);
        SearchFlightClient client2 = mock(SearchFlightClient.class);
        SearchFlightClient client3 = mock(SearchFlightClient.class);

        when(client1.search(any(), any(), any())).thenReturn(List.of(
                flight1,
                flight3
        ));
        when(client2.search(any(), any(), any())).thenReturn(List.of(
                flight1Cheaper,
                flight2,
                flight4
        ));
        when(client3.search(any(), any(), any())).thenReturn(List.of(
                flight1,
                flight4
        ));

        // Test case
        SearchFlightService searchFlightService = SearchFlightServiceFactory.fromClients(client1, client2, client3);
        SearchResult searchResult = searchFlightService.search(Airport.londonHeathrow, Airport.parisCharlesDeGaulle, from);

        // Assert results
        assertThat(searchResult.flights()).hasSize(4).containsExactly(flight1Cheaper, flight2, flight3, flight4);
    }
}
