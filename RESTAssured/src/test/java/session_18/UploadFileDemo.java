package session_18;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UploadFileDemo {

	@Test
	public void fileUpload() {

		// create file oject

		File testFileUpload = new File("C:\\Users\\Restu.Kumari\\Downloads\\fileUploadDemo.txt");
		File testFileUpload2 = new File("C:\\Users\\Restu.Kumari\\Downloads\\fileUploadDemo2.txt");

		// create request specification

		RequestSpecification reqSpec = RestAssured.given();
		Response res = reqSpec.baseUri("http://httpbin.org/post").multiPart("file1", testFileUpload)
				.multiPart("file2", testFileUpload2).post();

		res.prettyPrint();
		Assert.assertEquals(res.statusCode(), 200, "checck for status code of upload file");

	}

	@Test

	public void uploadImage() {

		File testImageUpload = new File("C:\\Users\\Restu.Kumari\\Downloads\\demo1.png");

		RequestSpecification reqSpec = RestAssured.given();
		Response res = reqSpec.baseUri("https://petstore.swagger.io/v2/pet/1/uploadImage")
				.multiPart("file1", testImageUpload).post();

		res.prettyPrint();
		Assert.assertEquals(res.statusCode(), 200, "checck for status code of upload image");

	}

}
