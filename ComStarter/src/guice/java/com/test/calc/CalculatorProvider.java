package com.test.calc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.google.inject.Inject;
import com.google.inject.Provider;

public class CalculatorProvider implements Provider<Calculator> {

	private Map<CalcType, Calculator> binder;
	private Random random;
	private List<CalcType> types;

	@Inject
	public CalculatorProvider(Map<CalcType, Calculator> binder, Random random) {
		this.binder = binder;
		this.random = random;

		types = new ArrayList<CalcType>() {
			private static final long serialVersionUID = 1L;
			{
				add(CalcType.Scientific);
				add(CalcType.Simple);
			}
		};
	}

	@Override
	public Calculator get() {
		return binder.get(types.get(random.nextInt(types.size())));
	}

}