package com.as.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.as.enums.ConfigProperty;
import com.as.utils.PropertyUtils;

public class RetryFailedTest implements IRetryAnalyzer {

	
	private int count=0;
	private int retry=1;
	
	@Override
	public boolean retry(ITestResult result) {
		boolean value=false;
	
		if(PropertyUtils.get(ConfigProperty.RETRYFAILEDTEST).equalsIgnoreCase("yes")) {
			
			 value=count<retry;
			count++;
			return  value;
		}

		return false;
	

}}
