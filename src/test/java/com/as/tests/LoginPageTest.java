package com.as.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.as.driver.DriverManager;

//1. Never hardcode
//ctrl+shift+o - will import automatically
//keep right things at right place
//class or interface name: ArvindSharma
// final constant values: ARVINDSHARMA  or ARVIND_SHARMA
//method name: arvindSharma
//package name: arvindsharma

public final class LoginPageTest extends BaseTest {

	private LoginPageTest()
	{
		
	}
	
	

   @Test
   public void test1()
   {
	   DriverManager.getDriver().findElement(By.name("q")).sendKeys("Automation",Keys.ENTER);
      
   }

   
  





}
