package ChainingJira;

import org.testng.annotations.BeforeMethod;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseClass {
	
	public static String Issue_ID;
	public RequestSpecification input;
	public static Response response;
	public static String incNum;
	
	@BeforeMethod
	public void setUp() {
		
		// End point
				RestAssured.baseURI="https://testingapi.atlassian.net/rest/api/2/issue/";
				
				//Authentication
				
				RestAssured.authentication=RestAssured.preemptive().basic("greet.anj10@gmail.com", 
	"ATATT3xFfGF06NJgVWRNzDD1K1xrWHoYzhTBpNgIQiDgdyItuUkJcXR22KvI-wo7YCEYjvpe2b_6iOBHwjBlcwUL2_yNX7b6NOc8eejlGzNpSCHG9JNY_kzT-FmzyppOo4l9-sUpV3QujeEhr0wHljJzYQHXQ9y_nPPmSwcuMuCjJVHfROzFPew=0962DA42");
				
		
	}

}