package com.as.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.as.driver.DriverManager;

public final class HomepageTest extends BaseTest {

	
	private HomepageTest()
	{
		
	}
	
	
	@Test
	public void Test3()
	{
		DriverManager.getDriver().findElement(By.name("q")).sendKeys("nana",Keys.ENTER);
	}
	
	
	
	
}
