package com.as.pages;

import org.openqa.selenium.By;

import com.as.enums.WaitStrategy;
import com.as.utils.DecodeUtils;

//locator priority
/*id
 *name
 *classname
 *linktext
 *partiallinktext
 *css or xpath 
 */

//variable name convention
/* for link name shoud be starting with link (Ex- linklogin or linkLogin) 
 * for button name shoud be starting with button or btn (Ex- buttonLogin or btnLogin)
 * drpdwnCounty 
 * */
public final class OrangeHRMLoginPage extends BasePage{


	private final By username= By.name("username");
    private final By password= By.name("password");
    private final By btnLogin= By.tagName("button");
  

	public OrangeHRMLoginPage enterUsername(String name)
	{
         sendKeys(username, name, "username");
        
         //Java8 
	//	new WebDriverWait(DriverManager.getDriver(),Duration.ofSeconds(10)).until(d->d.findElement(username).isEnabled());
		
		return this;
	}

	public OrangeHRMLoginPage enterPassword(String pass)
	{
		sendKeys(password, DecodeUtils.getDecodedString(pass), "password");
		
		
	    return this;
	}

	public OrangeHRMHomePage clickLogin()
	{
		click(btnLogin,WaitStrategy.NONE, "Login button");
		
		
		return new OrangeHRMHomePage();
	}

	public String gettitle()
	{
		return getTitle();
	}
	
	
}



