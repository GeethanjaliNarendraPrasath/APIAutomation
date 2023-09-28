package ChainingJira;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteIssue extends BaseClass {

	@Test(dependsOnMethods = "ChainingJira.UpdateIssue.update")
	public void delete() {
		
		
		//Send Request
		
		Response response = RestAssured.delete("/"+Issue_ID);
		response.then().assertThat().statusCode(Matchers.equalTo(204));
		System.out.println(response.getStatusCode());
	}
}
