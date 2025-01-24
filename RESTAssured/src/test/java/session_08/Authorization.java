package session_08;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Authorization {

	@Test
	public void BasicAuth() {

		RequestSpecification reqSpec = RestAssured.given();

		reqSpec.baseUri("http://postman-echo.com");
		reqSpec.basePath("/basic-auth");
		
		
        //non-preemptive -> first time it will not give username and password ; then server will explicitly ask for user and pass ; then it will send ; so 2 req will make
	    //	Response res = reqSpec.auth().basic("postman", "password").get();
		
		
		
		//preemptive -> first time it will send auth
		Response res = reqSpec.auth().preemptive(). basic("postman", "password").get();
		
		Assert.assertEquals(res.statusCode(), 200, "statuscode of BasicAuth does not matches");
		System.out.println("Response status of basic Auth : " + res.statusLine());
		System.out.println("Response body of basic Auth : " + res.body().asPrettyString());

	}
	
	
	
	@Test
	public void DigestAuth() {
		RequestSpecification reqSpecification = RestAssured.given();

		reqSpecification.baseUri("http://httpbin.org/");
		reqSpecification.basePath("digest-auth/undefined/restu/restu");
		//digestAuth is non preemptive in nature s
		Response response = reqSpecification.auth().digest("restu", "restu").get();
		
		Assert.assertEquals(response.statusCode(), 200, "StatusCode of digestAuth does not match");
		
		System.out.println("response of DigestAuth:" +response.statusLine());
		System.out.println("responsebody of DigestAuth:" +response.body().asPrettyString());
		
	}

}
