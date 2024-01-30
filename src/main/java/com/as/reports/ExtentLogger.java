package com.as.reports;

import com.as.enums.ConfigProperty;
import com.as.utils.PropertyUtils;
import com.as.utils.ScreenshotUtils;
import com.aventstack.extentreports.MediaEntityBuilder;

public final class ExtentLogger {

	private ExtentLogger() {}

	
	public static void pass(String message) {
		
		ExtentManager.getTest().pass(message);
	}
	
	
	public static void  fail(String message) {
		
		ExtentManager.getTest().fail(message);
	}
	
    
	public static void skipped(String message) {
		
		ExtentManager.getTest().skip(message);
	}
	
	public static void pass(String message, boolean needScreenshot )
	{
		if(PropertyUtils.get(ConfigProperty.PASSEDSTEPSSCREENSHOT).equalsIgnoreCase("yes") && needScreenshot)
		{
		   ExtentManager.getTest().pass(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());	
		}
		else
		{
			pass(message);
		}
		
	}
	
	public static void fail(String message, boolean needScreenshot ) 
	{
		if(PropertyUtils.get(ConfigProperty.FAILEDSTEPSSCREENSHOT).equalsIgnoreCase("yes") && needScreenshot)
		{
		   ExtentManager.getTest().fail(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());	
		}
		else
		{
			fail(message);
		}
		
	}
	
	public static void skipped(String message, boolean needScreenshot ) 
	{
		if(PropertyUtils.get(ConfigProperty.SKIPPEDSTEPSSCREENSHOT).equalsIgnoreCase("yes") && needScreenshot)
		{
		   ExtentManager.getTest().skip(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());	
		}
		else
		{
			skipped(message);
		}
		
	}




	
	
}
