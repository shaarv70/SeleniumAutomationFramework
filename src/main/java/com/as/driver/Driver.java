package com.as.driver;

import java.util.Objects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.as.utils.ReadPropertyFile;


public final class Driver {
	
	
	private Driver()
	{
		
	}

	private static WebDriver driver;
	
	public static void initDriver() throws Exception {
		if(Objects.isNull(DriverManager.getDriver())) {
		DriverManager.setDriver(new ChromeDriver());
		DriverManager.getDriver().get(ReadPropertyFile.get("url"));
		}

}
	
	public static void tearDown()
	{
		if(Objects.nonNull(driver)) {
	    DriverManager.getDriver().quit();
		 DriverManager.unload();
		
		
		
		}
	}
	
	
	
}
