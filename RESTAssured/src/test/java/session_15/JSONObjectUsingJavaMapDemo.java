package session_15;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class JSONObjectUsingJavaMapDemo {

	@Test
	public void createAuthToken() {
		
		
		//create JSON Object using JAVA MAp
		
		HashMap <String, String> authToken = new HashMap<String, String>();
		authToken.put("username", "admin");
		authToken.put("password","password123");
		
		
		
		
		
		
		Response res= RestAssured.given().
		baseUri("https://restful-booker.herokuapp.com/auth").
		contentType(ContentType.JSON)
		.body(authToken)
		.post()
;		
		
		System.out.println("Response of createAuthToken:" +res.asPrettyString());
		
		
		Assert.assertEquals(res.statusCode(), 200, "check for status code of createAuthToken" );
		
	}
	
	
	
	@Test
	public void createUser() {
		//value can be anything ; so we are keeping datatype of value as generic -> object
		HashMap <String, Object> userData = new HashMap<String, Object>();
		userData.put("firstName", "Red");
		userData.put("lastName", "Kim");
		userData.put("age", 28);
		userData.put("salary", 10000.56);
		userData.put("IsMarried", false);
		
		ArrayList<String> hobbies = new ArrayList<String>();
		hobbies.add("Music");
		hobbies.add("computers");
		hobbies.add("games");
		userData.put("Hobbies", hobbies);
		
		HashMap <String, String> techSkill = new HashMap<String, String>();
		techSkill.put("Programming language", "Java");
		techSkill.put("WebAutomation", "Selenium");
		techSkill.put("API testing", "Rest Assured");
		
		userData.put("TechSkill", techSkill);
		
 	 	
		
		Response resOfUser= RestAssured.given().
				baseUri("https://reqres.in/api/users").
				contentType(ContentType.JSON)
				.body(userData)
				.post();
		
		
		
		Assert.assertEquals(resOfUser.statusCode(), 201, "check for statuscode of resOfUser");
	}
	
	
}
