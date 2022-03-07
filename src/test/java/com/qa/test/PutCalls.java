package com.qa.test;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;

import io.restassured.http.ContentType;

public class PutCalls {
	public void putExample() {
		//with Header
		JSONObject req = new JSONObject();

		req.put("name","Tom");
		req.put("job","Musician");

		given().
		header("Content-Type","application/json")
		.accept(ContentType.JSON).
		body(req.toJSONString()).
		when().
		put("https://reqres.in/api/users/2").
		then().
		statusCode(200).log().all();  ///
	}
}
