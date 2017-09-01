package com.guardedsuspension;

import java.util.UUID;

public class StringProvider implements Provider<String> {
	 
	@Override
	public String provide() {
		return UUID.randomUUID().toString();
	}

}
