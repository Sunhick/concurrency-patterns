package com.leadersfollowers.taxi;

/**
 * Line represents a Handle class in the paper.
 *
 */
public interface Line {
	EventType get_type();
	Passenger wait_for_passenger();
}