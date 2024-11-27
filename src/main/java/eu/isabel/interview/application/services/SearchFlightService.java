package eu.isabel.interview.application.services;

import eu.isabel.interview.domain.models.Airport;
import eu.isabel.interview.domain.models.SearchResult;

import java.time.LocalDate;

/**
 * This represents the main API. {@link SearchFlightService#search(Airport, Airport, LocalDate)} is called whenever a
 * user press the "Search" button on the website.
 */
@FunctionalInterface
public interface SearchFlightService {

    /**
     * Search for flights between 2 Airports on a specific date
     *
     * @param from The departure Airport
     * @param to   The destination Airport
     * @param date The desired date of the Flight
     * @return The Flights found for the criteria
     */
    SearchResult search(Airport from, Airport to, LocalDate date);

}
