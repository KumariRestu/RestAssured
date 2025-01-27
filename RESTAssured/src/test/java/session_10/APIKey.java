package session_10;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class APIKey {

	@Test
	
	public void getWeatherData() {
		
		RequestSpecification reqspec = RestAssured.given();
		 reqspec.baseUri("https://api.openweathermap.org");
		 reqspec.basePath("/data/2.5/weather");
		 reqspec.queryParam("q", "Delhi").queryParam("appid", "ed9997485c5aebf644a45kef046becfceb6e6");
		
		Response res = reqspec.get();
		
		
		String responseBody= res.getBody().asPrettyString(); 
		
		System.out.println("response :" +responseBody);
		
		Assert.assertEquals(res.statusCode(), 200);
		
		
		System.out.println("Response status line" +res.statusLine());
	}
	
	
}
