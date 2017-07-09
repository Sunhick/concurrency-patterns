package com.activeobject;

import java.util.Optional;

public class Future {
	public Optional<Integer> answer;
	
	public Integer getAnswer() throws Exception {
		if (answer.isPresent()) {
			return answer.get();
		}
		throw new Exception("no result available");
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
