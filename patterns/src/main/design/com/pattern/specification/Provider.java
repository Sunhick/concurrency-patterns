package com.pattern.specification;

public interface Provider<T> {
	T provide();
	void reset();
}
