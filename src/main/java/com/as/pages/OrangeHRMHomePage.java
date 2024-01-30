 package com.as.pages;

import org.openqa.selenium.By;

import com.as.enums.WaitStrategy;

public final class OrangeHRMHomePage extends BasePage  {
	
	private final By profile =By.xpath("//p[@class='oxd-userdropdown-name']");
	private final By logoutBtn= By.xpath("//a[normalize-space()='Logout']");
	

	
	public OrangeHRMHomePage clickProfile()
	{
		
		click(profile,WaitStrategy.VISIBILLITY,"profile");
		
		return this;
	}
	
	public OrangeHRMLoginPage clickLogout()
	{
		click(logoutBtn,WaitStrategy.NONE,"Logout button");
		
		
		return new OrangeHRMLoginPage();
	}
	
	
	
	
	
	
	
	
	
	

}
