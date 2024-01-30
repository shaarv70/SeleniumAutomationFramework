package com.as.listeners;

import java.util.Arrays;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.as.annotations.FrameworkAnnotation;
import com.as.reports.ExtentLogger;
import com.as.reports.ExtentReport;

public class ListenerClass implements ITestListener , ISuiteListener
{

	@Override
	public void onStart(ISuite suite) {
		
			ExtentReport.initReports();
	
	}

	
	@Override
	public void onFinish(ISuite suite) {
		
		
			ExtentReport.flushReports();
	
	}

	@Override
	public void onTestStart(ITestResult result) {
		ExtentReport.createTest(result.getMethod().getDescription());
	    ExtentReport.addAuthors(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.class).author());
	    ExtentReport.addCategory(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.class).category());    
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		ExtentLogger.pass(result.getMethod().getMethodName()+" is passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		try {
			ExtentLogger.fail(result.getMethod().getMethodName()+" is failed",true);
			ExtentLogger.fail(result.getThrowable().toString());
			ExtentLogger.fail(Arrays.toString(result.getThrowable().getStackTrace()));
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		try {
			ExtentLogger.skipped(result.getMethod().getMethodName()+" is skipped", true);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	/*
	 * As of now it is not used
	 * 
	 * */
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
		/*
		 * As of now it is not used
		 * 
		 * */
		
		
	}

	@Override
	public void onStart(ITestContext context) {
		
		/*
		 * As of now it is not used
		 * 
		 * */
	}

	@Override
	public void onFinish(ITestContext context) {
	
		/*
		 * As of now it is not used
		 * 
		 * */
		
	}


	}
