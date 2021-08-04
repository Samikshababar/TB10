package com.log4j.Exp;

import java.io.IOException;

import org.apache.log4j.Appender;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.FileAppender;
import org.apache.log4j.HTMLLayout;
import org.apache.log4j.Layout;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.SimpleLayout;
import org.apache.log4j.xml.XMLLayout;

public class Demo {
	
	static Logger log=Logger.getLogger(Demo.class.getName());
	public static void main(String[] args) throws IOException 
	{
	
		//BasicConfigurator.configure();
	
	//	Layout l=new PatternLayout();
		//Layout l=new SimpleLayout();
		//Layout l=new HTMLLayout();
		//Layout l=new XMLLayout();
	
	//	Appender ap=new FileAppender(l,"xyz.txt");
		
	//	log.addAppender(ap);
		
		log.debug("DEBUG");
		log.info("INFO");
		log.warn("WARN");
		log.error("ERROR");
		log.fatal("FATAL");
		
		System.out.println("Hello");
		
		
		
	}


}
