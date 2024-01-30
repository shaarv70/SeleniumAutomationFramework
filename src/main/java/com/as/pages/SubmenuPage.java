package com.as.pages;

import org.openqa.selenium.By;

import com.as.enums.WaitStrategy;
import com.as.utils.DynamicXpathUtils;

public final class SubmenuPage extends BasePage{



	private static String standard= "//a[text()='%s']";
	
	public LaptopPage clickLaptopButton(String menutext)  {
		
		String laptopButton=DynamicXpathUtils.getXpath(standard,menutext);
		jsClick(By.xpath(laptopButton),WaitStrategy.PRESENCE, "Laptops option");
		return new LaptopPage();	
	}




	public DiskAndStoragePage clickDiskAndStorageButton(String menutext)
	{
		String driverAndStorage=DynamicXpathUtils.getXpath(standard,menutext);
		click(By.xpath(driverAndStorage),WaitStrategy.CLICKABLE,"Disk and Storage button");
		return new DiskAndStoragePage();
	}

}
