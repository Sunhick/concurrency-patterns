package com.leadersfollowers.taxi;

/**
 * Passenger represents a Concrete event handler.
 * I could have made this class an interface and 
 * could have had concrete event handler something
 * like TaxiPassenger, BusPassenger, etc.
 *
 */
public interface Passenger {
	void handle_event();
	Line get_handle();
}
