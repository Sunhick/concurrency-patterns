package com.config;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@XStreamAlias("depends")
public class Depends {
	@XStreamAlias("id")
	@XStreamAsAttribute
	private String id;
	
	@XStreamAlias("name")
	@XStreamAsAttribute
	private String name;
	
	@XStreamAlias("path")
	@XStreamAsAttribute
	private String path;
	
	public String getPath() {
		return path;
	}
	
	public String getName() {
		return name;
	}
	
	public String getId() {
		return id;
	}
}