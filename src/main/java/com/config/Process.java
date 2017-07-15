package com.config;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@XStreamAlias("process")
public class Process {
	// 	<process id="group.0.process.0" name="Main" path="~/prv/silk/comm.starter.Main" ui="true"/>
	@XStreamAlias("id")
	@XStreamAsAttribute
	private String id;
	
	@XStreamAlias("name")
	@XStreamAsAttribute
	private String name;
	
	@XStreamAlias("path")
	@XStreamAsAttribute
	private String path;

	@XStreamAlias("ui")
	@XStreamAsAttribute
	private Boolean ui;
	
	public String getId() { return id; }
	
	public String getName() { return name; }
	
	public String getPath() { return path; }
	
	public Boolean getUi() { return ui; }
}