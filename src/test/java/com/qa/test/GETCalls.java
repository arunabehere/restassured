package com.qa.test;

import static org.testng.Assert.assertEquals;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class GETCalls {
	String URL = "https://reqres.in";
	String getAPI1 = "/api/unknown/2";

	@Test(priority=0)
	public void getExample() {

		Response response = get(URL+getAPI1); //without object when static import is done
		int var = response.getStatusCode();

		System.out.println(response.getBody());

		assertEquals(var,200);
		System.out.println("Test 1 Passed");

	}

	@Test(priority=1)
	public void getShorterWay() {

		given().get(URL+getAPI1).then().statusCode(200);
		System.out.println("Test 2 Passed");

	}

	@Test(enabled=false)
	public void getFailure() {

		given().get(URL+getAPI1).then().statusCode(201); //Assertion will fail as value of actual statuscode is 200 
		System.out.println("Test 3 Passed");

	}

	@Test(priority=3)
	public void responseFromList() {

		given().get("https://reqres.in/api/users?page2")
		.then()
		.statusCode(200)  
		.body("data.id[0]",equalTo(1));

		System.out.println("Test 3 passed");
	}

	@Test
	public void itemList() {

		given().get("https://reqres.in/api/users?page2")
		.then()
		.statusCode(200)  
		.body("data.last_name",hasItems("Weaver","Holt"));

		System.out.println("Test 4 passed");
	}

}
