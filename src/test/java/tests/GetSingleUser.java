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

public class GetSingleUser {
	Response response;
	GetPropertyValue property = new GetPropertyValue();
	
	private static Logger log = LogManager.getLogger(GetSingleUser.class.getName());

	@BeforeMethod
	public void setUp() {
		//sessionID = BaseTest.doLogin();
	}

	@Test
	public void getSingleUser() {
		log.info("Starting Get User Test");
		String URI = URL.getEndPoint(property.getPropertyValue("usersResource") + property.getPropertyValue("userID"));	
		response = RESTCalls.GETRequest(URI);
		BaseAssertion.verifyStatusCode(response, Integer.parseInt(property.getPropertyValue("statusCode200")));
		
		System.out.println("Complete response :" + response.asString());
		System.out.println("Status code :" + response.getStatusCode());
		System.out.println("Does reponse contains 'email'? :" + response.asString().contains("email"));
	}
}
