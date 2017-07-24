package com.config;

import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("processes")
public class Processes {
	@XStreamImplicit(itemFieldName = "process")
	private List<Process> process = new ArrayList<Process>();

	@XStreamAlias("id")
	@XStreamAsAttribute
	private String id;

	@XStreamAlias("name")
	@XStreamAsAttribute
	private String name;
	
	@XStreamAlias("restartCount")
	@XStreamAsAttribute
	private String restartCount;

	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}
	
	public Integer getRestartCount() {
		return Integer.parseInt(restartCount);
	}

	public List<Process> getProcess() {
		return process;
	}

	// @XStreamImplicit(itemFieldName = "services")
	// private List<Service> services = new ArrayList<Process>();
}