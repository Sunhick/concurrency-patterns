package com.activeobject;

import java.util.Optional;

public class Future {
	public Optional<Integer> answer;
	
	public synchronized Integer getAnswer() throws Exception {
		if (answer == null || !answer.isPresent()) {
			// System.out.println("waiting for server");
			this.wait();
		}
		
		// System.out.println("getAnswer. id = " + Thread.currentThread().getId());
		return answer.get();
		// throw new Exception("no result available");
	}
	
	public void show() {
		try {
			System.out.println("server answer here: " + getAnswer());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
