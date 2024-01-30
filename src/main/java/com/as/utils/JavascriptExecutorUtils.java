package com.as.utils;

import org.openqa.selenium.JavascriptExecutor;

import com.as.driver.DriverManager;

public final class JavascriptExecutorUtils {

	private JavascriptExecutorUtils() {}


	public static JavascriptExecutor getJavsScriptExecutor()
	{
		JavascriptExecutor js;
		js=(JavascriptExecutor)DriverManager.getDriver();
		return  js;
	}

}
