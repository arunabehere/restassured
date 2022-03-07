package com.qa.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.utils.ExcelUtil;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class PostCalls {
   //with map
	String URL = "https://reqres.in";
	String createUser = "/api/users";
	Object[] [] data ;
	public static String excelPath = "./resources/testdata.xlsx"; 
	
	@Test(enabled=false)
	public void postExample1() {
		
		Map<String , Object> hashmap = new HashMap<>();
		
		hashmap.put("name","Jackson");
		hashmap.put("job","IT");
		
		JSONObject req = new JSONObject(hashmap);
		given().
		body(req.toJSONString()).
		when().
		post(URL+createUser).
		then().
		statusCode(201);
	}
	
	@Test(enabled=false)
	public void postExample2() {
		//without map
		JSONObject req = new JSONObject();
		
		req.put("name","Jackson");
		req.put("job","IT");
				
		given().
		body(req.toJSONString()).
		when().
		post(URL+createUser).
		then().
		statusCode(201);
	}
	
	@Test(enabled=false)
	public void postExample3() {
		//with Header
		JSONObject req = new JSONObject();
		
		req.put("name","Tom");
		req.put("job","Teacher");
		
		given().
		header("Content-Type","application/json")
		.accept(ContentType.JSON).
		body(req.toJSONString()).
		when().
		post(URL+createUser).
		then().
		statusCode(201).log().all();  ///
	}
	
	@DataProvider (name = "getTestData")
	public Object[][] getTestData() {
		
		ExcelUtil obj = new ExcelUtil(excelPath,"Sheet1");
		try {
			data = obj.getCellData();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
	
	@Test(dataProvider = "getTestData")
	public void postWithTestData(Object value) {
		System.out.println("value is "+value);
	}

}
