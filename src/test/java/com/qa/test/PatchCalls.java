package com.qa.test;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PatchCalls {

	
	@Test
	public void patchExample() {
		//with Header
		JSONObject req = new JSONObject();
		
		req.put("name","Tom");
		req.put("job","Musician");
		
		given().
		header("Content-Type","application/json")
		.accept(ContentType.JSON).
		body(req.toJSONString()).
		when().
		patch("https://reqres.in/api/users/2").
		then().
		statusCode(200).log().all();  ///
	}
}
