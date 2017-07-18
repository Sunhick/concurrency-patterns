package com.activeobject;

import java.util.HashMap;
import java.util.Map;

public class MathArgs {
	
	private Map<String, Integer> args = new HashMap<String, Integer>();
	
	// argument names
	public static String _0 = "args.0";
	public static String _1 = "args.1";
	public static String _2 = "args.2";

	public Integer getValue(String key) {
		return args.get(key);
	}

	public void putValue(String key, Integer value) {
		args.put(key, value);
	}
}
