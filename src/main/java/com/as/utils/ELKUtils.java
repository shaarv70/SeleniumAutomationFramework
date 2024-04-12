package com.as.utils;


import static io.restassured.RestAssured.given;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;

import com.as.enums.ConfigProperty;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public final class ELKUtils {

	private ELKUtils() {}
	public static void sendDetailsTOELK(String testname, String status)
	{
		if(PropertyUtils.get(ConfigProperty.SENDRESULTSTOELK).equals("yes"))
		{
			Map<String,String> mymap=new HashMap<>();
			mymap.put("testname",testname);
			mymap.put("status", status);
			mymap.put("executionTime",LocalDateTime.now().toString());

			Response response=given().baseUri(PropertyUtils.get(ConfigProperty.ELASTICURL)).contentType(ContentType.JSON).body(mymap).
					log().all().post(PropertyUtils.get(ConfigProperty.NEWINDEX));
			Assert.assertEquals(response.statusCode(), 201);
			response.prettyPrint();
		}}

	public static void deleteIndex()
	{
		if(PropertyUtils.get(ConfigProperty.DELETEINDEX).equals("yes"))
		{
		given().baseUri(PropertyUtils.get(ConfigProperty.ELASTICURL)).log().all().
		delete(PropertyUtils.get(ConfigProperty.DELETINGINDEX));
				
		}
	}
}