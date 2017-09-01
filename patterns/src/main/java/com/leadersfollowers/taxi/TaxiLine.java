package com.leadersfollowers.taxi;

import java.util.ArrayList;
import java.util.List;

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
}
