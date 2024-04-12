package com.as.factories;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import com.as.enums.ConfigProperty;
import com.as.utils.PropertyUtils;

public final class DriverFactory {

	private DriverFactory() {}

	public static WebDriver getDriver(String browser ,String version) throws MalformedURLException  {
		WebDriver driver=null;
		if(browser.equalsIgnoreCase("chrome"))
		{
			if(PropertyUtils.get(ConfigProperty.RUNMODE).equals("remote")) {
				
				ChromeOptions options= new ChromeOptions();
				options.setBrowserVersion(version);
				
				options.setCapability("selenoid:options", new HashMap<String, Object>() {{
				    /* How to add test badge */
				    put("name", "test 1");

				    /* How to set session timeout */
				    put("sessionTimeout", "15m");

				    /* How to set timezone */
				    put("env", new ArrayList<String>() {{
				        add("TZ=UTC");
				    }});

				    /* How to add "trash" button */
				    put("labels", new HashMap<String, Object>() {{
				        put("manual", "true");
				    }});

				    /* How to enable video recording */
				    put("enableVideo", false);
				    put("enableVNC",true);
				}});
			   driver=new RemoteWebDriver(new URL(PropertyUtils.get(ConfigProperty.GRIDURL)),options);
				
			}
			else
			{	driver= new ChromeDriver();

			}
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			if(PropertyUtils.get(ConfigProperty.RUNMODE).equals("remote")) {
				
				FirefoxOptions options = new FirefoxOptions();
	            options.setBrowserVersion(version);
	            options.setCapability("selenoid:options", new HashMap<String, Object>() {{
	                /* How to add test badge */
	                put("name", "Test badge...");

	                /* How to set session timeout */
	                put("sessionTimeout", "15m");

	                /* How to set timezone */
	                put("env", new ArrayList<String>() {{
	                    add("TZ=UTC");
	                }});

	                /* How to add "trash" button */
	                put("labels", new HashMap<String, Object>() {{
	                    put("manual", "true");
	                }});

	                /* How to enable video recording */
	                put("enableVideo", true);
	                
	                put("enableVNC",true);
	            }});
	         
				
				driver= new RemoteWebDriver(new URL(PropertyUtils.get(ConfigProperty.GRIDURL)),options);
				
			}
			else
			{
				driver= new FirefoxDriver();
			}
		}
		return driver;
		
	
	}
}

