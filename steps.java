package stepDef;

import java.io.File;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class steps {
	public static RequestSpecification input;
	public static Response response;
	public static String Issue_ID;
	
	@Given("Set the endpoint")
	public void setEndpoint() {
	RestAssured.baseURI="https://testingapi.atlassian.net/rest/api/2/issue/";
	}
	
	@And("Set the Auth")
	public void setAuth() {
	
		RestAssured.authentication=RestAssured.preemptive().basic("greet.anj10@gmail.com", 
				"ATATT3xFfGF06NJgVWRNzDD1K1xrWHoYzhTBpNgIQiDgdyItuUkJcXR22KvI-wo7YCEYjvpe2b_6iOBHwjBlcwUL2_yNX7b6NOc8eejlGzNpSCHG9JNY_kzT-FmzyppOo4l9-sUpV3QujeEhr0wHljJzYQHXQ9y_nPPmSwcuMuCjJVHfROzFPew=0962DA42");
							
}
	
	@When("create issue with file {string}")
	public void createIssueFile(String fileName) {
		File file=new File("./src/test/resources/"+fileName);
		input=RestAssured.given()
				.contentType("application/json").body(file);
			    response=input.post();
			    Issue_ID = response.jsonPath().getString("id");
	}
	
	@When("Get Ticket")
	public void GetTicket() {
	   
	input  = RestAssured.given();
	response = input.get("/"+Issue_ID);
	
	
	}
	
	@When("Update Issue {string}")
	public void updateIssue(String body) {
		input=RestAssured.given()
		.contentType("application/json").body(body);
			    response=input.put("/"+Issue_ID);
		
	}
	@When("Delete Issue")
	public void deleteIssue() {
		
		response=RestAssured.delete("/"+Issue_ID);
	}
	
	@Then("Validate response code as {int}")
	    public void validateResponseCode(int statusCode) {
		
		response.then().assertThat().statusCode(statusCode);
	    	
	    }
}

