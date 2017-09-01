package com.leadersfollowers.taxi;

import java.util.ArrayList;
import java.util.List;

/**
 * Taxi stand corresponds to the class ThreadPool
 * in the paper cited in README.md file.
 *
 * Taxi stand contains a collection of Taxi drivers
 * waiting to pick up passengers in the taxi line.
 */
public class TaxiStand {
	
	private List<TaxiDriver> followers;
	private TaxiDriver leader;
	
	TaxiStand() {
		followers = new ArrayList<TaxiDriver>();
	}
	
	public void join(TaxiDriver driver) {
		if (leader == null) {
			leader = driver;
			return;
		}
	}
	
	public void promote_new_leader() {
		
	}
}
