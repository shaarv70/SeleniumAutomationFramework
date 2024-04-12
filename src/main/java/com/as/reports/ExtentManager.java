package com.as.reports;

import java.util.Objects;

import com.aventstack.extentreports.ExtentTest;

public final class ExtentManager {
	
	
	private ExtentManager() {}
	private static ThreadLocal<ExtentTest> extTest= new ThreadLocal<ExtentTest>();

	//if we are not giving any access modifier then it means it is having default as the access modifier - which means
	// it has the visibility within the package only
	
	static ExtentTest getTest()
	{
		return extTest.get();
	}
	
	static void setTest(ExtentTest ref ) {
	  if(Objects.nonNull(ref)) {
		  extTest.set(ref);
	  }
		
	}
	
	static void unload()
	{
		extTest.remove();
	}
	

}
