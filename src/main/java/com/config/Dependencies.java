package com.config;

import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("dependencies")
public class Dependencies {
	
	@XStreamImplicit(itemFieldName="depends")
	private List<Depends> depends = new ArrayList<Depends>();
	
	public List<Depends> Depends {
		return depends;
	}
}