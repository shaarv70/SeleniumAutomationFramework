package com.as.tests;

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
	
	
	@BeforeMethod
	protected void setup() throws Exception {         // Since this will be used by all child classes so we cannot make it private 

		Driver.initDriver();
		
	}

	@AfterMethod
	protected void tearDown() {

	Driver.tearDown();
		
	}
}
