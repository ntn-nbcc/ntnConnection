package com.ntn.utils;

import org.apache.log4j.Logger;

public class NTNLogger {
	Logger logger = Logger.getLogger(NTNLogger.class);
	private String targetClass = "Logger";
	
	public NTNLogger() {
		// TODO Auto-generated constructor stub
	}

 	
	public NTNLogger(String target)
	{
		targetClass = target;
	}
	
	public void info(String info)
	{
		logger.info(targetClass + ":" + info);
	}
	
	public void error(String description,Exception e)
	{
		logger.error(targetClass +":" +description+":",e);
	}
	
	public void debug(String debug)
	{
		logger.debug(targetClass + ":"  + debug);
	}
}
