package com.as.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.as.constants.FrameworkConstants;
import com.as.exceptions.FrameworkExceptions;
import com.as.exceptions.InvalidPathForExcelException;

public final class ExcelUtils {
	
	private ExcelUtils() {}
	
	public static List<Map<String,String>> getTestDetails(String sheetname)
	{
		DataFormatter formatter= null;
		List<Map<String,String>> testlist=null;
		try(FileInputStream fs =new FileInputStream(FrameworkConstants.getTestdatapath());
				XSSFWorkbook xf=  new XSSFWorkbook(fs);	) {
			 
			XSSFSheet xs= xf.getSheet(sheetname);
			int lastrownum= xs.getLastRowNum();
			int lastcolnum= xs.getRow(0).getLastCellNum();
		
			
			Map<String,String> testdetails = null;
			testlist= new ArrayList<>();
			formatter= new DataFormatter();
			
			for(int i=1;i<=lastrownum;i++)
			{
				testdetails=new LinkedHashMap<>();
				for(int j=0;j<lastcolnum;j++)
				{
					String key = formatter.formatCellValue(xs.getRow(0).getCell(j));
					String value=formatter.formatCellValue(xs.getRow(i).getCell(j));
					testdetails.put(key,value);
				}
				
				testlist.add(testdetails);
			}
		} catch (FileNotFoundException e) {
			StackTraceElement[] a=e.getStackTrace();
			a[0]=new StackTraceElement("com.as.utils.ExcelUtils","getTestDetails", "ExcelUtils.java",26);
			e.setStackTrace(a);
			throw new InvalidPathForExcelException("The specefied file is not present",e);
			
		} catch (IOException e) {
			throw new FrameworkExceptions("Some io exception while reading excel file");
			
		}
			
		
		  return testlist; 
		
		
		
		
	}

}
