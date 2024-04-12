package com.as.tests;

import java.util.Map;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import com.as.annotations.FrameworkAnnotation;
import com.as.enums.Category;
import com.as.pages.OrangeHRMLoginPage;

public class OrangeHRMTest extends BaseTest {

	private OrangeHRMTest()
	{

	}

	@FrameworkAnnotation(author = { "Arvind","Sachin" }, category = {Category.REGRESSION,Category.SMOKE})
	@Test
    public void loginLogoutTest(Map<String,String> mymap)
	{

		
		String title=new OrangeHRMLoginPage().enterUsername(mymap.get("username")).enterPassword(mymap.get("password")).clickLogin().
				      clickProfile().clickLogout().
				      gettitle();

		Assertions .assertThat(title).isEqualTo("OrangeHRM");

	}
	
	@FrameworkAnnotation(author = { "Arvind","Sachin" }, category = {Category.REGRESSION,Category.SMOKE})
	@Test
	 public void newTest(Map<String,String> mymap)
		{

			
			String title=new OrangeHRMLoginPage().enterUsername(mymap.get("username")).enterPassword(mymap.get("password")).clickLogin().
					      clickProfile().clickLogout().
					      gettitle();

			Assertions .assertThat(title).isEqualTo("OrangeHRM");

		}

	
			
			
		
	}




