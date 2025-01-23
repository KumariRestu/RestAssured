package session_07;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class QueryParameter {

	@Test

	public void filterData() {

		RequestSpecification reqSpec = RestAssured.given();

		reqSpec.baseUri("https://reqres.in");
		reqSpec.basePath("/api/users");
		// add query param and upend query param
		reqSpec.queryParam("page", 2).queryParam("id", 2);

		// perform get request

		Response res = reqSpec.get();

		String ResponseBody = res.getBody().asPrettyString();
		
		System.out.println("responsebody :" + ResponseBody);
		
		
		JsonPath jsonPathViewer= res.jsonPath();
		String firstName = jsonPathViewer.get("data.first_name")	;
		
		Assert.assertEquals(firstName, "Janet","First_Name is not matching");

	}

}
