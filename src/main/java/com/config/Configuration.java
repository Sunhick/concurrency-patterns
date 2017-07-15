package com.config;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.starter.Starter;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;

public class Configuration {
	
	private final static Logger log = Logger.getLogger(Starter.class.getSimpleName());
	
	public static void main(String[] args) {
		XStream stream  = new XStream();
		stream.addPermission(AnyTypePermission.ANY);
		stream.processAnnotations(Processes.class);
		stream.processAnnotations(Process.class);  
		
		try {
			String fileString = new String(Files.readAllBytes(Paths.get("config.xml")), 
					StandardCharsets.UTF_8);
			Processes p = (Processes)stream.fromXML(fileString);
			
			log.info(p.getName());
			for (Process e : p.getProcess()) {
				log.info(e.getId());
				log.info(e.getUi().toString());
			}
		} catch (IOException e1) {
			log.log(Level.SEVERE,"Error in config file.", e1);
			e1.printStackTrace();
		}
	}
}
