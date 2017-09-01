package com.guardedsuspension;

public interface Queue<T extends Object> {
	void put(T element);
	T get();
	boolean isEmpty();
	boolean isFull();
}