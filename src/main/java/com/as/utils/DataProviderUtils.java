package com.as.utils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;

import com.as.constants.FrameworkConstants;

public final class DataProviderUtils {
	
	private DataProviderUtils() {}

	private static List<Map<String, String>> testdata =new ArrayList<>();
	@DataProvider(parallel = true)
	public static Object[] getData(Method m) {
		String testname=m.getName();

		if(testdata.isEmpty())
		{
			testdata=ExcelUtils.getTestDetails(FrameworkConstants.getTestdata());
		}

		List<Map<String,String>> allTest= new ArrayList<>();

		for(int i=0;i<testdata.size();i++)
		{
			if(testname.equalsIgnoreCase(testdata.get(i).get("testname"))

					&& testdata.get(i).get("execute").equalsIgnoreCase("yes"))

			{    
				allTest.add(testdata.get(i));
			}	


		}

		
		return allTest.toArray();

	}
}
