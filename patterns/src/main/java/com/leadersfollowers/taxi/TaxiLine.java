package com.leadersfollowers.taxi;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Taxi line represents a concrete handle. 
 * This is where all passenger waiting for a taxi
 * will be in.
 *
 */
public class TaxiLine implements Line {
	private List<TaxiLine> waiting;
	
	TaxiLine() {
		waiting = new ArrayList<>();
	}

	@Override
	public EventType get_type() {
		return EventType.Taxi;
	}

	@Override
	public Passenger wait_for_passenger() {
		// this has to wait for the next available passenger.
		// I should inject a passenger provider here. but for 
		// now I will just fake it.
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// random passenger
		return new TaxiPassenger(UUID.randomUUID().toString());
	}
}
