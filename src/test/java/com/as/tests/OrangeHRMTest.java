package com.as.tests;

import java.util.Map;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import com.as.pages.OrangeHRMLoginPage;

public class OrangeHRMTest extends BaseTest {

	private OrangeHRMTest()
	{

	}

	@Test
    public void loginLogoutTest(Map<String,String> mymap)
	{

		
		String title=new OrangeHRMLoginPage().enterUsername(mymap.get("username")).enterPassword(mymap.get("password")).clickLogin().
				      clickProfile().clickLogout().
				      gettitle();

		Assertions .assertThat(title).isEqualTo("OrangeHRM");

	}
	
	@Test
	 public void newTest(Map<String,String> mymap)
		{

			
			String title=new OrangeHRMLoginPage().enterUsername(mymap.get("username")).enterPassword(mymap.get("password")).clickLogin().
					      clickProfile().clickLogout().
					      gettitle();

			Assertions .assertThat(title).isEqualTo("OrangeHRM");

		}

	
			
			
		
	}




