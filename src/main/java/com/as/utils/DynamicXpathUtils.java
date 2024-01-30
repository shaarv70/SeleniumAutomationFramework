package com.as.utils;

public final class DynamicXpathUtils {
	
	private DynamicXpathUtils(){}	
	
	
	public static String getXpath(String xpath,String menutext)
	{
		 return String.format(xpath, menutext);
	  
	
	
	}
	
	

}
