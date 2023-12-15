package com.as.driver;

import org.openqa.selenium.WebDriver;

public final class DriverManager {

	private DriverManager()
	{
		
	}
	
	private static ThreadLocal<WebDriver> dr= new ThreadLocal<>();

	public static WebDriver getDriver()
	{
		return dr.get();
	}
	
	public static void setDriver(WebDriver ref ) {
		
		dr.set(ref);
	}
	
	public static void unload()
	{
		dr.remove();
	}
	



}
