package com.leadersfollowers.taxi;

public class TaxiPassenger implements Passenger {
	
	private String name;

	TaxiPassenger(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return name;
	}

	@Override
	public void handle_event() {
		
	}

	@Override
	public Line get_handle() {
		return null;
	}

}
