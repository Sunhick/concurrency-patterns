package com.test.calc;

import com.google.inject.AbstractModule;
import com.google.inject.assistedinject.FactoryModuleBuilder;
import com.google.inject.multibindings.MapBinder;

public class CalcModule extends AbstractModule {

	@Override
	protected void configure() {
		MapBinder<CalcType, Calculator> binder = MapBinder.newMapBinder(binder(), CalcType.class, Calculator.class);

		binder.addBinding(CalcType.Simple).to(SimpleCalculator.class);
		binder.addBinding(CalcType.Scientific).to(ScientificCalculator.class);

		bind(Calculator.class).toProvider(CalculatorProvider.class);
		
		// for assisted inject
		install(new FactoryModuleBuilder()
                .implement(Operation.class, SingleOperation.class)
                .build(SingleOperation.SingleOperationFactory.class));
	}
}