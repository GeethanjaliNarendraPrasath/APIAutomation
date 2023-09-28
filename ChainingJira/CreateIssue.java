package ChainingJira;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateIssue extends BaseClass {
	
	@Test
	public void create() {
		
		
		//Add Request
		
		 input = RestAssured.given()
		.contentType("application/json")
		.accept("application/json")
		.when().body("{\r\n"
				+ "    \"fields\": {\r\n"
				+ "        \"project\": {\r\n"
				+ "            \"key\": \"RES\"\r\n"
				+ "        },\r\n"
				+ "        \"summary\": \"create issue in RA project\",\r\n"
				+ "        \"description\": \"Creating of an issue using project keys and issue type names using the REST API\",\r\n"
				+ "        \"issuetype\": {\r\n"
				+ "            \"name\": \"Bug\"\r\n"
				+ "        }\r\n"
				+ "    }\r\n"
				+ "}");
		
		// Send Request 
		
		 response = input.post();
		response.then().assertThat().statusCode(Matchers.equalTo(201));
		 Issue_ID = response.jsonPath().getString("id");
		 System.out.println(Issue_ID);
			System.out.println(response.getStatusCode());
		 
		
		
	}

}
