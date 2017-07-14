package com.config;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.starter.Starter;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.AnyTypePermission;

public class Configuration {
	
	private final static Logger log = Logger.getLogger(Starter.class.getSimpleName());
	
	public static void main(String[] args) {
		XStream stream  = new XStream();
		stream.addPermission(AnyTypePermission.ANY);
		
		stream.alias("processes", Processes.class);
		stream.alias("process", Process.class);
		stream.alias("dependencies", Dependencies.class);
		
//		stream.addImplicitCollection(Processes.class, "processes");
//		stream.addImplicitCollection(Process.class, "process");
//		stream.addImplicitCollection(Dependencies.class, "dependencies");
		
		try {
			String fileString = new String(Files.readAllBytes(Paths.get("/Users/Sunny/prv/github/JStarter/src/main/java/com/config/xjc" + 
					"/config.xml")), 
					StandardCharsets.UTF_8);
			Processes p = (Processes)stream.fromXML(fileString);
			
			for (Process e : p.process) {
				log.info(e.id);
			}
		} catch (IOException e1) {
			log.log(Level.SEVERE,"Error in config file.", e1);
			e1.printStackTrace();
		}
	}
}
