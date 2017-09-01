package com.leadersfollowers.taxi;

public class Starter {

	public static void main(String[] args) {
		TaxiStand seattleStand = new TaxiStand();
		TaxiDriver john = new TaxiDriver();
		TaxiDriver olive = new TaxiDriver();
		TaxiDriver sunil = new TaxiDriver();
		
		seattleStand.join(john);
		seattleStand.join(olive);
		seattleStand.join(sunil);
	}

}
