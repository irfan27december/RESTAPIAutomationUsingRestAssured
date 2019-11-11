package com.RestAssuredCore;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;



import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RESTCalls {
	/*
	 * This call will be responsible to fire requests
	 */

	private static Logger log = LogManager.getLogger(RESTCalls.class.getName());
	public static Response GETRequest(String URI) {
		log.info("Inside GETRequest call");
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.contentType(ContentType.JSON);
		Response response = requestSpecification.get(URI);
		log.debug(requestSpecification.log().all());
		return response;
	}
}
