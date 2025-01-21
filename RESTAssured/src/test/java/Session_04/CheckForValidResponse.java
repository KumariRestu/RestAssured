package Session_04;

import static org.testng.Assert.*;
import org.testng.annotations.Test;


import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
public class CheckForValidResponse {
	//https://reqres.in/api/users?page=2
	
	
	@Test
	
	public void GetSingleUser() {
		
		
		baseURI= "https://reqres.in/api/users?page=2";
		
		//get request specification of request 
		
		RequestSpecification requestSpec = given();
		//call get method
	  Response response = requestSpec.get();		
		
	 int statusCode =  response.getStatusCode();
	 
	 //validate -> actual,excepted
	 assertEquals(statusCode, 200, "Correct code received");
	 
	 //validate status line 
	 String statusLine = response.getStatusLine();
	 //assert 
	 assertEquals(statusLine, "HTTP/1.1 200 OK", "Incorrect status line");
	
	 
		
	}
	
	
	
@Test
	
	public void GetSingleUserUSingValidateResponse() {
		
		
		baseURI= "https://reqres.in/api/users/2";
		
		//get request specification of request 
		
		RequestSpecification requestSpec = given();
		//call get method
	  Response response = requestSpec.get();		
	
	 //instead of assert we can use validate response
	 
	ValidatableResponse validateRes = response.then();
	
	//status code
	validateRes.statusCode(200);
	
	
	//status line 
	validateRes.statusLine("HTTP/1.1 200 OK");
	
	 
		
	}


@Test

public void BDDGetsingleuser() {
	
	
	
	
	given().
	
	when().get("https://reqres.in/api/users/2")
	
	.then().statusCode(200).statusLine("HTTP/1.1 200 OK");
	
	
	
	
}

}
