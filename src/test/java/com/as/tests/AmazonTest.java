package com.as.tests;

import java.util.Map;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import com.as.annotations.FrameworkAnnotation;
import com.as.enums.Category;
import com.as.pages.AmazonHomePage;

public  class AmazonTest extends BaseTest {

	private AmazonTest() {}
	
	@FrameworkAnnotation(author = { "Arvind","Sachin" }, category = {Category.REGRESSION,Category.SMOKE})
	@Test
	public void amazonTest(Map<String,String> data) 
	{
		String title=new AmazonHomePage().clickHamBurger().clickMobileComputerButton().clickLaptopButton(data.get("menutext")).gettitleofPage();
		Assertions.assertThat(title).isNotNull().isNotBlank();
		
	}
	
}
