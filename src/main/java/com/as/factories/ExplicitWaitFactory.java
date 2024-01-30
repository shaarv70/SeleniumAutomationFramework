package com.as.factories;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.as.constants.FrameworkConstants;
import com.as.driver.DriverManager;
import com.as.enums.WaitStrategy;

public class ExplicitWaitFactory {
	
	private ExplicitWaitFactory() {}


  
	public static WebElement explicitWait(WaitStrategy waitstrategy ,By  by)
	{
		WebElement element =null;
		
		if(waitstrategy ==WaitStrategy.CLICKABLE)
		{
		  element=	new WebDriverWait(DriverManager.getDriver(),Duration.ofSeconds(FrameworkConstants.getExplicitwait())).
			until(ExpectedConditions.elementToBeClickable(by));
		}
		
		else if(waitstrategy ==WaitStrategy.PRESENCE)
		{
			element= new WebDriverWait(DriverManager.getDriver(),Duration.ofSeconds(FrameworkConstants.getExplicitwait())).
			until(ExpectedConditions.presenceOfElementLocated(by));
		}
	    
		else if(waitstrategy ==WaitStrategy.VISIBILLITY)
		{
			element= new WebDriverWait(DriverManager.getDriver(),Duration.ofSeconds(FrameworkConstants.getExplicitwait())).
			until(ExpectedConditions.visibilityOfElementLocated(by));
		}
	
		else if(waitstrategy ==WaitStrategy.NONE)
		{
			element =DriverManager.getDriver().findElement(by);
		}
		
		return element;
	    
	}



}
