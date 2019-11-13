package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetRequestWithQueryParameters  {
	@Test
	public void filterUser() {

		RestAssured.baseURI = "https://reqres.in/api";

		Response response = null;

		try {
			response = RestAssured.given()
					.when().queryParam("page", "2").queryParam("id", 5)
					.get("/users");
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Response :" + response.asString());
		System.out.println("Status Code :" + response.getStatusCode());
		int expectedStatusCode = 200;
		Assert.assertEquals(response.getStatusCode(), expectedStatusCode);

	}
}
