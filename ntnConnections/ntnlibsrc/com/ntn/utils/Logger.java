/*
 * Created on May 16, 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.ntn.utils;

/**
 * @author sjhaveri
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class Logger {

	private String targetClass = "Logger";
	
	public Logger(String target)
	{
		targetClass = target;
	}
	
	public void info(String info)
	{
		System.out.println(targetClass + ":" + info);
	}
	
	public void error(String description,Exception e)
	{
		System.out.println(description);
		e.printStackTrace();
	}
	
	public void debug(String debug)
	{
		System.out.println(targetClass + ":"  + debug);
	}

}
