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

	public Terminal() {
		handles = new ArrayList<>(Arrays.asList(new TaxiLine()));
	}

	public void handle_events() {

	}

	public void deactivate_handle() {

	}

	public void reactivate_handle() {

	}

	public void select() {

	}

}