package com.leadersfollowers.taxi;

public class Starter {

	public static void main(String[] args) {
		Terminal seattleTerminal = new Terminal();
		TaxiStand taxiStand = new TaxiStand();
		TaxiDriver john = new TaxiDriver(seattleTerminal, taxiStand, "John");
		TaxiDriver olive = new TaxiDriver(seattleTerminal, taxiStand, "Olive");
		TaxiDriver sunil = new TaxiDriver(seattleTerminal, taxiStand, "Sunil");
		
		taxiStand.join(john);
		taxiStand.join(olive);
		taxiStand.join(sunil);
	}

}
