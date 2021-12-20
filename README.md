# Isabel KUBE interview task

For this task we are developing a backend application
which is used by a web application to search for available flights.

The **SearchFlightService** is called with the following parameters: *from*, *to* and *date*.
Our backend uses several **SearchFlightClients** to fetch available fligths which conform to the criteria and aggregates the results.
The results are ordered from best to worst.

# Tasks:
1. Implement `fromTwoClients` which creates a `SearchFlightService` by combining the results from two
   `SearchFlightClient`. For example, imagine we fetch flight data from Swissair and lastminute.com.
   Please order the aggregated flights using the "best" ordering strategy (see `SearchResult`).

2. Several clients can return data for the same flight. For example, if we combine data
   from British Airways and lastminute.com, lastminute.com may include flights from British Airways.
   Update `fromTwoClients` so that if we get two or more flights with the same `flightId`,
   `SearchFlightService` selects the flight with the lowest `unitPrice` and discards the other ones.

3. A client may occasionally throw an exception. `fromTwoClients` should
   handle the error gracefully, for example log a message and ignore the error.
   In other words, `fromTwoClients` should consider that a client which throws an exception
   is the same as a client which returns an empty list.

4. Implement `fromClients` which behaves like `fromTwoClients` but it takes a list of `SearchFlightClient`.
   Note: You can use a recursion/loop/reduce to call all the clients and combine their results.
   Note: We can assume `clients` to contain less than 100 elements.

5. Each client's search request is executed sequentially - one after another.
   Currently, we only send the request to client 2 after we have received the response from client 1.
   Instead, it would be better to send both search requests concurrently

6. Bonus:
   Implement the concurrent approach for 'fromClients'.
   `fromClients` waits for the results from every single client. This means that
   if one client is extremely slow, it will slow down the overall request.
   Implement a timeout per client so that the service doesn't spend more than
   500 milliseconds per client.

There is a test implementation available for the **SearchFlightClient**.