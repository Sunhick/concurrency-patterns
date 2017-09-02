package com.leadersfollowers.taxi;

import java.util.ArrayList;
import java.util.List;

/**
 * Taxi stand corresponds to the class ThreadPool in the paper cited in
 * README.md file.
 *
 * Taxi stand contains a collection of Taxi drivers waiting to pick up
 * passengers in the taxi line.
 */
public class TaxiStand {
	private List<TaxiDriver> followers;
	private TaxiDriver leader;

	TaxiStand() {
		followers = new ArrayList<TaxiDriver>();
	}

	public void join(TaxiDriver driver) {
		if (driver.get_state() != DriverState.Processing) {
			// kick off this thread.
			new Thread(driver).start();
			System.out.println("new thread started!");
		}

		// Do we wait here for sometime to make sure thread started ?
		// Do thread miss notify event if we call notify before they are
		// even started?
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// if there's no leader then let's promote this guys as leader.
		if (leader == null) {
			promote_new_leader(driver);
			return;
		}

		driver.become_follower();
		followers.add(driver);
	}

	private void promote_new_leader(TaxiDriver driver) {
		driver.become_leader();
		leader = driver;

		synchronized (leader) {
			// wake up this driver to look out for incoming passengers.
			leader.notify();
		}
	}

	public void promote_new_leader() {
		// drop the client at his destination.
		// till then leader is processing the client request.
		leader.become_processing();

		if (followers.isEmpty()) {
			return;
		}
		
		// look for a next leader.
		// easy thing to do is to pick the next driver in line.
		TaxiDriver driver = followers.remove(0);
		promote_new_leader(driver);
	}
}
