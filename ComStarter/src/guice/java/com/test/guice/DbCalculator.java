package com.test.guice;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.test.calc.Calculator;

public class DbCalculator {
	private Provider<Calculator> calcProvider;
	private Provider<DB> dbProvider;

	@Inject
	public DbCalculator(Provider<Calculator> calcProvider, Provider<DB> dbProvider) {
		this.calcProvider = calcProvider;
		this.dbProvider = dbProvider;
	}

	public void addOperate(String q1, String q2) {
		DB db = dbProvider.get();
		Integer a = db.query(q1);
		Integer b = db.query(q2);

		Integer c = calcProvider.get().add(a, b);
		System.out.println("answer = " + c);
	}
}