package com.test.guice;

import java.util.Map;

import com.google.inject.Inject;
import com.google.inject.Provider;

public class DbProvider implements Provider<DB> {

	private Map<DbType, DB> binder;

	@Inject
	public DbProvider(Map<DbType, DB> binder) {
		this.binder = binder;
	}

	@Override
	public DB get() {
		return binder.get(DbType.InMemoryDb);
	}
}