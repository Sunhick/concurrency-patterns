package com.leadersfollowers.taxi;

public interface Driver extends Runnable {
	void become_leader();
	void become_follower();
	void become_processing();
	DriverState get_state();
	void quit();
}