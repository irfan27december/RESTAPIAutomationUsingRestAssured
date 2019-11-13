package tests;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.RestAssuredCore.BaseAssertion;
//import com.RestAssuredCore.BaseTest;
import com.RestAssuredCore.RESTCalls;
import com.utils.PayloadGenerator;
import com.utils.URL;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CreateUser {

	private String sessionID;
	Response response;

	private static Logger log = LogManager.getLogger(CreateUser.class.getName());

	@BeforeMethod
	public void setUp() {
		//sessionID = BaseTest.doLogin();
	}

	@Test
	public void createIssue() {
		log.info("Starting Create Issue Test");
		String URI = URL.getEndPoint("/api/users");
		String createUserPayLaod = PayloadGenerator.generatePayLoadString("CreateUser.json");
		response = RESTCalls.POSTRequest(URI, createUserPayLaod);
		BaseAssertion.verifyStatusCode(response, 201);

		// First get the JsonPath object instance from the Response interface
		JsonPath jsonPathEvaluator = response.jsonPath();

		// Then simply query the JsonPath object to get a String value of the node
		// specified by JsonPath: id (Note: You should not put $. in the Java code)
		String id = jsonPathEvaluator.get("id");

		// Let us print the city variable to see what we got
		System.out.println("ID  " + id);

	}

}
