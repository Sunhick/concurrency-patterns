package com.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.io.IOUtils;

import com.github.arunsoman.ipc.mappedbus.MappedBusWriter;
import com.google.inject.Inject;
import com.starter.Bootstrap;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;

public class Configuration {

	private final static Logger log = Logger.getLogger(Bootstrap.class.getSimpleName());
	private final XStream stream;

	@Inject
	public Configuration(XStream stream) {
		this.stream = stream;
		stream.addPermission(AnyTypePermission.ANY);
		stream.processAnnotations(Processes.class);
		stream.processAnnotations(Process.class);
		stream.processAnnotations(Dependencies.class);
		stream.processAnnotations(Depends.class);
	}

	public Processes parse(String file) {
		try (InputStream fs = Configuration.class.getResourceAsStream("config.xml")) {
			String fileString = IOUtils.toString(fs);
			return (Processes) stream.fromXML(fileString);
		} catch (IOException e1) {
			log.log(Level.SEVERE, "Error in config file.", e1);
		}
		return null;
	}

	public static void main(String[] args) {

		MappedBusWriter wr = new MappedBusWriter("/Users/Sunny/prv/comm", 200L, 1, false);
		try {
			wr.open();
		} catch (Exception e) {
			log.log(Level.SEVERE, "error", e);
		}

		XStream stream = new XStream();
		stream.addPermission(AnyTypePermission.ANY);
		stream.processAnnotations(Processes.class);
		stream.processAnnotations(Process.class);
		stream.processAnnotations(Dependencies.class);
		stream.processAnnotations(Depends.class);

		try {
			InputStream fs = Configuration.class.getResourceAsStream("config.xml");
			String fileString = IOUtils.toString(fs);
			Processes p = (Processes) stream.fromXML(fileString);

			log.info(p.getName());
			for (Process e : p.getProcess()) {
				log.info(e.getName());
				Dependencies deps = e.getDeps();
				if (deps != null) {
					// log.info(deps.getName().orElse("Nothing"));
					for (Depends d : deps.getDepends()) {
						log.info(d.getName());
					}
				}
			}

			XStream xstream = new XStream(new JettisonMappedXmlDriver());
			xstream.setMode(XStream.NO_REFERENCES);
			xstream.addPermission(AnyTypePermission.ANY);
			xstream.processAnnotations(Processes.class);
			xstream.processAnnotations(Process.class);
			xstream.processAnnotations(Dependencies.class);
			xstream.processAnnotations(Depends.class);

			System.out.println(xstream.toXML(p));
			log.info("");
		} catch (IOException e1) {
			log.log(Level.SEVERE, "Error in config file.", e1);
			e1.printStackTrace();
		}
	}
}
