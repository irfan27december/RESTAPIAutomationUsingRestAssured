package tests;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.RestAssuredCore.BaseAssertion;
import com.RestAssuredCore.RESTCalls;
import com.utils.GetPropertyValue;
import com.utils.URL;

import io.restassured.response.Response;

public class DeleteUser {
	Response response;
	GetPropertyValue property = new GetPropertyValue();
	
	private static Logger log = LogManager.getLogger(DeleteUser.class.getName());

	@BeforeMethod
	public void setUp() {
		//sessionID = BaseTest.doLogin();
	}

	@Test
	public void deleteUser() {
		log.info("Starting Delete User Test");
		String URI = URL.getEndPoint(property.getPropertyValue("usersResource") + property.getPropertyValue("userID"));	
		response = RESTCalls.DELETERequest(URI);
		BaseAssertion.verifyStatusCode(response, Integer.parseInt(property.getPropertyValue("statusCode204")));
		
		System.out.println("Complete response :" + response.asString());
		System.out.println("Status code :" + response.getStatusCode());
		//System.out.println("Does response contains 'email'? :" + response.asString().contains("email"));
	}
}

