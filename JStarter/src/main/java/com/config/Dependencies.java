package com.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("dependencies")
public class Dependencies {

	@XStreamImplicit(itemFieldName = "depends")
	private List<Depends> depends = new ArrayList<Depends>();

	@XStreamAlias("name")
	@XStreamAsAttribute
	private Optional<String> name = Optional.of("");
	
	public List<Depends> getDepends() {
		return depends;
	}

	public Optional<String> getName() {
		return name;
	}
}