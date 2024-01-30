package com.as.listeners;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

import com.as.constants.FrameworkConstants;
import com.as.utils.ExcelUtils;

public class MethodInterceptor implements IMethodInterceptor {

	@Override
	public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {

		List<Map<String,String>> mylist=ExcelUtils.getTestDetails(FrameworkConstants.getRunmanager());
		List<IMethodInstance> result= new ArrayList<>();


		for(int i=0;i<methods.size();i++)
		{
			for (int j=0;j<mylist.size();j++)
		   {
				if(methods.get(i).getMethod().getMethodName().equalsIgnoreCase(mylist.get(j).get("testname"))&&
				  
					mylist.get(j).get("execute").equalsIgnoreCase("yes"))
					{
						methods.get(i).getMethod().setDescription(mylist.get(j).get("test description"));
						methods.get(i).getMethod().setInvocationCount(Integer.parseInt(mylist.get(j).get("count")));
						methods.get(i).getMethod().setPriority(Integer.parseInt(mylist.get(j).get("priority")));
						result.add(methods.get(i));
					}

				
			}
		}
		return result;

	}

}
