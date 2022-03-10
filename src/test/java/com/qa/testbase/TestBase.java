package com.qa.testbase;

import org.apache.log4j.*;
import org.testng.annotations.BeforeClass;
import io.restassured.response.Response;

public class TestBase {
	
	//public static RequestSpecification req;
	public static Response resp;
	public Logger logger;
	
	@BeforeClass
	public void setUp() {
		logger = Logger.getLogger("RestAPI");
		PropertyConfigurator.configure("log4j.properties");
		logger.setLevel(Level.DEBUG);
	}

}
