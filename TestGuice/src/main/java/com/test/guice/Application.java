package com.test.guice;

import com.google.inject.Inject;
import com.test.calc.Calculator;
import com.test.calc.SingleOperation;
import com.test.calc.SingleOperation.SingleOperationFactory;

public class Application {
	private Calculator calc;
	private SingleOperationFactory opFactory;
	private DbCalculator dbCalc;

	@Inject
	public Application(Calculator calc, SingleOperationFactory opFactory, DbCalculator dbCalc) {
		this.calc = calc;
		this.opFactory = opFactory;
		this.dbCalc = dbCalc;
	}

	public void add(int a, int b) {
		System.out.println(this.calc.add(a, b));
	}

	public void sub(int a, int b) {
		System.out.println(this.calc.sub(a, b));
	}

	public void mul(int a, int b) {
		System.out.println(this.calc.mul(a, b));
	}

	public void div(int a, int b) {
		System.out.println(this.calc.div(a, b));
	}

	public void start() {
		int a = 9, b = 3;

		add(a, b);
		sub(a, b);
		mul(a, b);
		div(a, b);
		
		SingleOperation adder = opFactory.create(a, b, "sunil.adder");
		adder.perform();
		
		System.out.println("Type: " + calc.getClass().getCanonicalName());
		
		dbCalc.addOperate("query.0", "query.1");
	}
}