package ChainingJira;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateIssue extends BaseClass {

	@Test(dependsOnMethods = "ChainingJira.CreateIssue.create") //packageame.className.methodName
	public void update() {


		// Add Request

		input = RestAssured.given()
				.contentType("application/json")
				.when()
				.body("{\r\n"
						+ "    \"fields\": {\r\n"
						+ "        \"description\": \"Bug creation Using REST API for testing\"\r\n"
						+ "    }\r\n"
						+ "}");

		//Send Request

		response = input.put("/"+Issue_ID);
		response.then().assertThat().statusCode(Matchers.equalTo(204));
		System.out.println(response.getStatusCode());
		response.prettyPrint();

	}

}
