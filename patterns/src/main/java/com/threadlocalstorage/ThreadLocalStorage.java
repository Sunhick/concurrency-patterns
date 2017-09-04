package com.threadlocalstorage;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 
 * Thread local storage provides a way to store local information specific to
 * each thread. It's a mock implementation of java's ThreadLocal class.
 * Re-inventing the wheel purely for demonstration & learning purposes.
 *
 * @param <T>
 *            Type of object to be stored.
 */
public class ThreadLocalStorage<T> {
	/**
	 * map of thread and it's value set. Key is a combination of thread id & thread
	 * name.
	 */
	public Map<String, T> map;

	public ThreadLocalStorage() {
		map = new ConcurrentHashMap<>();
	}

	public T get() {
		String key = getCurrentThreadKey();
		if (map.containsKey(key)) {
			return map.get(key);
		}
		return null;
	}

	public void set(T obj) {
		if (obj == null) {
			// nothing to store.
			return;
		}

		// Get the thread id and name
		String key = getCurrentThreadKey();
		map.put(key, obj);
	}

	public void remove() {
		// Get the thread id and name
		String key = getCurrentThreadKey();
		if (map.containsKey(key)) {
			map.remove(key);
		}
	}

	public String getCurrentThreadKey() {
		Thread current = Thread.currentThread();
		long id = current.getId();
		String name = current.getName();

		return id + name;
	}
}
