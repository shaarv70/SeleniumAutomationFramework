package com.as.pages;

import org.openqa.selenium.By;

import com.as.enums.WaitStrategy;

public final class AmazonHomePage extends BasePage {


	private final By hamburger=By.xpath("//span[text()=\"All\"]//parent::a");
	private final By mobileComputerButton=By.xpath("//div[text()=\"Mobiles, Computers\"]//parent::a");

	String standard= "//a[text()='%s']";
  



	public  AmazonHomePage clickHamBurger() 
	{
		click(hamburger,WaitStrategy.CLICKABLE, "HamburgerButton");
		return this;
	}

	public SubmenuPage clickMobileComputerButton()  
	{
		click(mobileComputerButton,WaitStrategy.CLICKABLE,"mobile,computer button");
		return new SubmenuPage();
	}


	

	
}  

