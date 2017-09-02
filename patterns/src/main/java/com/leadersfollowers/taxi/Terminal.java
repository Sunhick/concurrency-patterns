package com.leadersfollowers.taxi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Terminal corresponds to HandleSet in the paper quoted in README.md.
 * 
 * This will have multiple transportation mechanism. Taxi is just one of them.
 * Taxi driver is going to be looking out for passengers waiting at taxi line.
 */
public class Terminal {

	private List<Line> handles;
	private Line handle;

	public Terminal() {
		handles = new ArrayList<>(Arrays.asList(new TaxiLine()));
	}

	public Passenger handle_events(EventType type) {
		select(type);
		
		// wait for the event.
		Passenger passenger = handle.wait_for_passenger();
		return passenger;
	}

	public void deactivate_handle() {

	}

	public void reactivate_handle() {

	}

	private void select(EventType type) {
		handle = get_handle(type);
	}

	private Line get_handle(EventType type) {
		for(Line h : handles) {
			if (h.get_type().equals(type)) {
				return h;
			}
		}
		
		return null;
	}

}