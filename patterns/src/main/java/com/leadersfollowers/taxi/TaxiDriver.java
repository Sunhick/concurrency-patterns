package com.leadersfollowers.taxi;

/**
 * Taxi driver corresponds to a Thread in 
 * the paper cited in markdown.
 *
 */
public class TaxiDriver implements Driver {

	private boolean leader = false;
	
	@Override
	public void become_leader() {
		leader = true;
	}

	@Override
	public void become_follower() {
		leader = false;
	}

}