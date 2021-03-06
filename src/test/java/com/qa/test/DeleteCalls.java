package com.qa.test;

import static io.restassured.RestAssured.when;

import org.testng.annotations.Test;

public class DeleteCalls extends PostCalls {

	
	PostCalls pc = new PostCalls();
	@Test
	public void deleteExample() {
		
		//to delete any record first create a record to maintain integrity
		
		pc.postExample3();
				
		when().
		delete("https://reqres.in/api/users/2").
		then().
		statusCode(204).log().all();  ///
	}
	
}
