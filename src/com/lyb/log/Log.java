package com.lyb.log;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Log {
	
	public static Logger getLogger(){
		Logger logger  =  Logger.getLogger(Log.class );
		PropertyConfigurator.configure( "src/sysconfig/log4j.properties" );		//Windows
//		PropertyConfigurator.configure( "sysconfig/log4j.properties" );			//Linux
		return logger;
	}
}