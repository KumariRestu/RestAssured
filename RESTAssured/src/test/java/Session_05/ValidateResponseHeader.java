package Session_05;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ValidateResponseHeader {

	@Test

	public void GetSingleUser() {

		RequestSpecification reqSpec = given();

		// baseUri

		reqSpec.baseUri("https://reqres.in");
		reqSpec.basePath("/api/users/2");

		Response response = reqSpec.get();

		// validate response header
		String contentType = response.header("Content-Type");
		System.out.println("print " + contentType);

		// read all response header attributes/ key and print the values
		Headers headersList = response.getHeaders();
		for (Header header : headersList) {
			System.out.println(header.getName() + header.getValue());
		}

		// validate header content_tyep application/json; charset=utf-8

		Assert.assertEquals(contentType, "application/json; charset=utf-8", "Header content type mismatched");
	}
}
