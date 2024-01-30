package com.as.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import com.as.driver.DriverManager;
import com.as.enums.WaitStrategy;
import com.as.factories.ExplicitWaitFactory;
import com.as.reports.ExtentLogger;
import com.as.utils.JavascriptExecutorUtils;

public class BasePage {



	protected void click(By by,WaitStrategy type, String elementName)
	{
		ExplicitWaitFactory.explicitWait(type,by).click();

		ExtentLogger.pass(elementName+" clicked",true);

	}


	protected static void jsClick(By by,WaitStrategy type, String elementName)
	{

		JavascriptExecutorUtils.getJavsScriptExecutor().executeScript("arguments[0].click()",ExplicitWaitFactory.explicitWait(type, by));

		ExtentLogger.pass(elementName+" clicked",true);


	}

	protected void sendKeys(By by, String text, String elementName)
	{
		ExplicitWaitFactory.explicitWait(WaitStrategy.VISIBILLITY,by).sendKeys(text);

		ExtentLogger.pass("Entered the "+ elementName, true );



	}

	protected String getTitle()
	{
		return DriverManager.getDriver().getTitle();
	}


}
