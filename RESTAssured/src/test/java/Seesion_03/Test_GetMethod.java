package Seesion_03;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import junit.framework.Assert;

public class Test_GetMethod {
	
	
	
	@Test
public void test01() {
	
		
	Response response = get("https://reqres.in/api/users?page=2");
		System.out.println ("Response code:" + response.getStatusCode());
		System.out.println("Response Body" +response.getBody().asString());
		System.out.println("Response time :"+ response.getTime());
		System.out.println("Response header :"+ response.getHeader("Content-Type"));
		
		
		int expectedStatusCode= 200;
		int Actualstatuscode= response.getStatusCode();
		Assert.assertEquals(expectedStatusCode, Actualstatuscode); 
		
}
	
	@Test
	public void test02() {
		
		
		baseURI="https://reqres.in/api/users";
		given().queryParam("page", 2).when().get().then().statusCode(200);
		
		
	}
	
}
