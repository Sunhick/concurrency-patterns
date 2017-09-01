package com.leadersfollowers.taxi;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Taxi driver corresponds to a Thread in the paper cited in markdown.
 *
 */
public class TaxiDriver implements Driver {

	private boolean leader = false;
	private AtomicBoolean run = new AtomicBoolean(true);

	@Override
	public void become_leader() {
		leader = true;
	}

	@Override
	public void become_follower() {
		leader = false;
	}

	@Override
	public void quit() {
		run.set(false);
	}

	@Override
	public void run() {
		while (run.get()) {
			// Guarded suspension pattern. This while precondition
			// prevents thread from spuriously waking up and assuming
			// a leader role.
			while (!leader) {
				try {
					// if he is not the leader, let this driver wait till his turn.
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			// must have been promoted to become leader.
			// let's assume the leader role and wait for 
			// next incoming passenger.
			
		}

	}

}