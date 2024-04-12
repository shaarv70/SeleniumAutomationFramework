package com.as.tests;

import java.util.Map;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.as.driver.Driver;

public class BaseTest {

	protected BaseTest()
	{
		
	}

	/*
	* First we have to give priority to private, protected, default : public should not be the default 
	*/
	//1. Never hardcode
	//ctrl+shift+o - will import automatically
	//keep right things at right place
	//class or interface name: ArvindSharma
	// final constant values: ARVINDSHARMA  or ARVIND_SHARMA
	//method name: arvindSharma
	//package name: arvindsharma
	
	
	@SuppressWarnings("unchecked")
	@BeforeMethod
	protected void setup(Object[] data) {         // Since this will be used by all child classes so we cannot make it private 
      Map<String,String> mymap=(Map<String,String>)data[0];
		
		Driver.initDriver(mymap.get("browser"),mymap.get("version"));
		
	}

	@AfterMethod
	protected void tearDown() {

	Driver.tearDown();
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
}
