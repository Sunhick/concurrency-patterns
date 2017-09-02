package com.leadersfollowers.taxi;

import java.util.concurrent.atomic.AtomicBoolean;

import jdk.management.resource.NotifyingMeter;

/**
 * Taxi driver corresponds to a Thread in the paper cited in markdown.
 *
 */
public class TaxiDriver implements Driver {

	private Terminal handleSet;
	private TaxiStand threadPool;
	private DriverState state;
	private AtomicBoolean run = new AtomicBoolean(true);
	private String name;

	public TaxiDriver(Terminal handleSet, TaxiStand threadPool, String name) {
		this.handleSet = handleSet;
		this.threadPool = threadPool;
		this.name = name;
		this.state = DriverState.Follower;
	}

	@Override
	public void become_leader() {
		state = DriverState.Leader;
	}

	@Override
	public void become_follower() {
		state = DriverState.Follower;
	}
	
	@Override
	public void become_processing() {
		state = DriverState.Processing;
	}

	@Override
	public void quit() {
		run.set(false);
	}

	@Override
	public DriverState get_state() {
		return state;
	}
	
	@Override
	public synchronized void run() {
		while (run.get()) {
			// Guarded suspension pattern. This while precondition
			// prevents thread from spuriously waking up and assuming
			// a leader role.
			while (state == DriverState.Follower) {
				try {
					System.out.println(name + " is waiting!");
					// if he is not the leader, let this driver wait till his turn.
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			System.out.println(name + " became leader.");
			
			// must have been promoted to become leader.
			// let's assume the leader role and wait for 
			// next incoming passenger.
			Passenger passenger = handleSet.handle_events(EventType.Taxi);
			
			// notification from handleSet that, there's a incoming event.
			threadPool.promote_new_leader();
			
			System.out.println(name + " is driving " + passenger.toString());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			threadPool.join(this);
		}

	}

}