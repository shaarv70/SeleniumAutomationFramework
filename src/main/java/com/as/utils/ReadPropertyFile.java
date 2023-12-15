package com.as.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

public final class ReadPropertyFile {

	private ReadPropertyFile(){

	}


	private static Properties property = new Properties();
	private static final Map<String,String>CONFIGMAP= new HashMap<String, String>();
	static {

		try {
			FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/config/config.properties");
			property.load(file);
			for (Map.Entry<Object,Object> mymap:property.entrySet())
			{
				CONFIGMAP.put(String.valueOf(mymap.getKey()),String.valueOf(mymap.getValue()));
			}
			
		//	property.entrySet().forEach(entry ->CONFIGMAP.put(String.valueOf(entry.getKey()),String.valueOf(entry.getValue())));JAVA -8
		}
		catch (FileNotFoundException e) {

			e.printStackTrace();
		} 
		catch (IOException e) {

			e.printStackTrace();
		}


	}

	
	
	public static String get(String key) throws Exception
	{
		if(Objects.isNull(key)|| Objects.isNull(CONFIGMAP.get(key)))
		{
			throw new Exception("Property name"+key+"is not found. Please check the config file");
		}
	
		return CONFIGMAP.get(key);
	}
	
	


}
