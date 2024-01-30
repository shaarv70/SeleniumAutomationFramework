package com.as.utils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import com.as.constants.FrameworkConstants;
import com.as.enums.ConfigProperty;
import com.as.exceptions.FrameworkExceptions;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {
	
	
	private JsonUtils(){

	}


	private static  Map<String,String>CONFIGMAP;
	static {

		try {
			
			CONFIGMAP= new ObjectMapper().readValue(new File(FrameworkConstants.getJsonconfigfilepath()),new TypeReference<HashMap<String,String>>(){});
			}
			
		//	property.entrySet().forEach(entry ->CONFIGMAP.put(String.valueOf(entry.getKey()),String.valueOf(entry.getValue())));JAVA -8
		
		catch (IOException e) {

			e.printStackTrace();
		    System.exit(0);
		}


	}

	
	
	public static String get(ConfigProperty key) 
	{
		if(Objects.isNull(key)|| Objects.isNull(CONFIGMAP.get(key.name().toLowerCase())))
		{
			throw new FrameworkExceptions("Property name"+key+"is not found. Please check the config file");
		}
	
		return CONFIGMAP.get(key.name().toLowerCase());
	}
	
	

}
