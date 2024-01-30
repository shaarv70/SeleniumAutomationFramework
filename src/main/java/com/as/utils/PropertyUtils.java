package com.as.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

import com.as.constants.FrameworkConstants;
import com.as.enums.ConfigProperty;
import com.as.exceptions.PropertyFileUsageException;

public final class PropertyUtils {

	private PropertyUtils(){

	}


	private static Properties property = new Properties();
	private static final Map<String,String>CONFIGMAP= new HashMap<>();
	static {

		try (FileInputStream file = new FileInputStream(FrameworkConstants.getConfigfilepath());){
			
			property.load(file);
			for (Map.Entry<Object,Object> mymap:property.entrySet())
			{
				CONFIGMAP.put(String.valueOf(mymap.getKey()),String.valueOf(mymap.getValue()).trim());
			}
			
		//	property.entrySet().forEach(entry ->CONFIGMAP.put(String.valueOf(entry.getKey()),String.valueOf(entry.getValue())));JAVA -8
		}
		catch (IOException e) {

			e.printStackTrace();
			System.exit(0);//here we are using this because in static blocks JVM will not control runtime exception and termination will not happen 
		} 


	}

	
	
	public static String get(ConfigProperty key)
	{
		if(Objects.isNull(key)|| Objects.isNull(CONFIGMAP.get(key.name().toLowerCase())))
		{
			throw new PropertyFileUsageException("Property name"+key+"is not found. Please check the config file");
		}
	
		return CONFIGMAP.get(key.name().toLowerCase());
	}
	
	


}
