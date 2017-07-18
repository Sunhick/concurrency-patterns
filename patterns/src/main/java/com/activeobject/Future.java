package com.activeobject;

import java.util.Optional;

public class Future {
	public Optional<Integer> answer;
	private MathArgs args;
	
	Future(MathArgs ar) {
		this.args = ar;
	}
	
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
			System.out.println("Got response. Add ( " + args.getValue(MathArgs._0) + ", " +
					args.getValue(MathArgs._1) + " ) = "+ getAnswer());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
