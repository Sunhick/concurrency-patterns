package com.concurrent;

import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * 
 * ConcurrentNavigableMapDemo.
 * 
 * Is an interace. it's impls - ConcurrentSkipListMap
 * 
 * {@link http://tutorials.jenkov.com/java-util-concurrent/concurrentnavigablemap.html}
 */
public class ConcurrentNavigableMapDemo {
	@SuppressWarnings("unused")
	private ConcurrentNavigableMap<String, Integer> map = new ConcurrentSkipListMap<String, Integer>();
}
