package com.test.guice;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.MapBinder;
import com.test.calc.CalcModule;

public class AppModule extends AbstractModule {

	@Override
	protected void configure() {
		// install dependency modules.
		install(new CalcModule());

		// configure application module bindings here.
		MapBinder<DbType, DB> binder = MapBinder.newMapBinder(binder(), DbType.class, DB.class);
		binder.addBinding(DbType.FileDb).to(FileDB.class);
		binder.addBinding(DbType.InMemoryDb).to(InMemoryDB.class);
		
		bind(DB.class).toProvider(DbProvider.class);
		bind(ScopedSingleton.class);
	}
}