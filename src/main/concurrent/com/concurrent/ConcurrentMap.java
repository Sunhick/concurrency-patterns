package com.concurrent;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 
 * ConcurrentMap
 * 
 * ConcurrentMap is an interace. It's implementations are -
 * 		ConcurrentHashMap
 */
public class ConcurrentMap {
	private Map<Integer, String> map = new ConcurrentHashMap<Integer, String>(10);
}
