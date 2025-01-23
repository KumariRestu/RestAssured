package session_06;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class ValidateJsonResponseBody {

	@Test
	public void UserListResponseBody() {

		// get requestSpecification Reference

		RequestSpecification requestSpec = RestAssured.given();

		// base url
		requestSpec.baseUri("https://reqres.in");
		requestSpec.basePath("api/users?page=2");

		// get request

		Response res = requestSpec.get();

		// read response body

		ResponseBody responsebody = res.getBody();

		// convert responsebody into string and print

		String resString = responsebody.asPrettyString();
		System.out.println("Response body:" + resString);

		// Assert check for presence of George in response body

		Assert.assertEquals(resString.contains("George"), true, "Check for George");

		// check in first_name we have Charles with json path

		JsonPath jsonPathView = responsebody.jsonPath();
		String firstName = jsonPathView.get("data[4].first_name");

		Assert.assertEquals(firstName, "Charles", "check for george on node 4");

	}

}
