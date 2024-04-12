package com.as.driver;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.Objects;

import com.as.enums.ConfigProperty;
import com.as.exceptions.BrowserInvocationFailedException;
import com.as.factories.DriverFactory;
import com.as.utils.PropertyUtils;

/**
 * This class is used to invoke the browser.
 * Browser will be invoked by Base Testmethod present with test classes
 * <p> This is for next line or break line</p>
 * <pre> This tag is used for formatter</pre>
 * 
 * 
 * January 25, 2024 
 * @author arvind.sharma3
 * @version 1.0
 * @since 1.0
 * @see DriverManager
 * @see com.as.tests.BaseTest
 */

public final class Driver {

	/**
	 * private constructor to avoid external instantiation
	 */
	private Driver()
	{

	}
	/**
	 * January 25, 2024
	 * @author arvind.sharma3
	 * @param browser will be passed from {@link com.as.tests.BaseTest} test and can be chrome or firefox
	 */


	public static void initDriver(String browser , String version) {
		if(Objects.isNull(DriverManager.getDriver())) {

			try {
			
				DriverManager.setDriver(DriverFactory.getDriver(browser, version));
		     	} 
			catch (MalformedURLException e) {

				throw new BrowserInvocationFailedException("Browser invocation failed");
		}

		}
		DriverManager.getDriver().manage().window().maximize();
		DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		DriverManager.getDriver().get(PropertyUtils.get(ConfigProperty.URL));
		
	}



	public static void tearDown()
	{
		if(Objects.nonNull(DriverManager.getDriver())) {
			DriverManager.getDriver().quit();
			DriverManager.unload();
		   


		}
	}



}
