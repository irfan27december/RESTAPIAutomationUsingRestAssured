package tests;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import org.testng.annotations.Test;
import io.restassured.RestAssured;

public class TestJsonSchema {

    @Test
    public void TestJsonSchema() {
    	String filePath = System.getProperty("user.dir")+"\\resources\\"+"JsonSchemaFile.json";
        RestAssured.given()
            .when()
            .get("https://jsonplaceholder.typicode.com/comments?postId=1")
            .then()
            .assertThat()
            .body(matchesJsonSchemaInClasspath("C:\\Users\\irfan\\git\\RESTAPIAutomationUsingRestAssured\\src\\test\\resources\\JsonSchemaFile.json"));

    }
}