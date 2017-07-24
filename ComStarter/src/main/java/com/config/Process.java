package com.config;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.converters.basic.BooleanConverter;

@XStreamAlias("process")
public class Process {
	@XStreamAlias("id")
	@XStreamAsAttribute
	private String id;

	@XStreamAlias("name")
	@XStreamAsAttribute
	private String name;

	@XStreamAlias("path")
	@XStreamAsAttribute
	private String path;
	
	@XStreamAlias("type")
	@XStreamAsAttribute
	private String type;
	
	@XStreamAlias("ui")
	@XStreamAsAttribute
	@XStreamConverter(value=BooleanConverter.class, booleans={true}, strings={"true", "false"})
	private Boolean ui = false;

	@XStreamAlias("dependencies")
	private Dependencies deps;

	public Dependencies getDeps() {
		return deps;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	public String getType() {
		return type;
	}

	public String getPath() {
		return path;
	}

	public Boolean getUi() {
		return ui;
	}
}