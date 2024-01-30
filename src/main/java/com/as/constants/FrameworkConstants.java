package com.as.constants;

import com.as.enums.ConfigProperty;
import com.as.utils.PropertyUtils;

public final class FrameworkConstants {

	private FrameworkConstants()
	{

	}

	private static final String RESOURCES=System.getProperty("user.dir")+"/src/test/resources";	
	private static final int EXPLICITWAIT=10; 
	private static final String CONFIGFILEPATH =RESOURCES+"/config/config.properties";
	private static final String JSONCONFIGFILEPATH=RESOURCES+"/config/config.json";
	private static final String EXTENTREPORTFOLDERPATH=System.getProperty("user.dir")+"/extent-test-output/";
	private static final String TESTDATAPATH=RESOURCES+"/excel/excel.xlsx";
	private static final String RUNMANAGER="RUNMANAGER";
	private static final String TESTDATA="TESTDATA";
	private static String EXTENTREPORTFILEPATH="";
	

	


	public static String getRunmanager() {
		return RUNMANAGER;
	}


	public static String getTestdata() {
		return TESTDATA;
	}


	public static String getNEWFILEPATH() 
	{       if(EXTENTREPORTFILEPATH.isEmpty())

	{
		EXTENTREPORTFILEPATH=createFilepath();
	}

	return EXTENTREPORTFILEPATH;
	}


	public static String createFilepath() {
		if(PropertyUtils.get(ConfigProperty.OVERRIDEREPORTS).equalsIgnoreCase("yes"))
		{
			return EXTENTREPORTFOLDERPATH+"index.html";
		}
		else
		{
			return   EXTENTREPORTFOLDERPATH+System.currentTimeMillis()+"/index.html";
		}
}
	
	public static String getTestdatapath() {
		return TESTDATAPATH;
	}

	public static String getJsonconfigfilepath() {
		return JSONCONFIGFILEPATH;
	}
	public static String getResources() {
		return RESOURCES;
	}
	public static int getExplicitwait() {
		return EXPLICITWAIT;
	}
	public static String getConfigfilepath() {
		return CONFIGFILEPATH;
	}



}
