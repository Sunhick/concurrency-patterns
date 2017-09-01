package com.leadersfollowers.taxi;

public interface Driver extends Runnable {
	void become_leader();
	void become_follower();
	void quit();
}