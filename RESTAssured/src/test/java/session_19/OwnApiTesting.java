package session_19;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class OwnApiTesting {

	@BeforeClass
	public void setUpDefault() {
		RequestSpecification req = given();

		 req.baseUri("http://localhost:3000/users");
		 
		 requestSpecification = req;
	}
	
	
	@Test
	public void readUserData() {


		Response res = get();

		res.prettyPrint();

	
		
		Assert.assertEquals(res.statusCode(),200, "Check for statuscode of OwnApiTesting");
	
	
	
	}
	
	@Test(enabled=false)
	public void CreateUserData() {
		
		
		//request body 
		
		HashMap <String , Object> jsonData = new HashMap<String, Object>();

		jsonData.put("name", "neha");	
		jsonData.put ("age", 35);
		
		
	Response res=	given().header("Content-type","application/json").
		contentType(ContentType.JSON).
		body(jsonData)
		.post()
;		
		
	
	Assert.assertEquals(res.statusCode(), 201, "Checkfor statuscode of CreateUserData");
		
		
	}
	
	
	@Test(enabled=false)
	public void putUserData() {
		
		HashMap <String , Object> jsonData = new HashMap<String, Object>();

		jsonData.put("name", "neha");	
		jsonData.put ("age", 27);
		
		
	Response res=	given().header("Content-type","application/json").
		contentType(ContentType.JSON).
		body(jsonData)
		.put("/975a")
;		
		
	
	System.out.println("--------------Response of PutUserData--------------");
	res.prettyPrint();
	
	Assert.assertEquals(res.statusCode(), 200, "Checkfor statuscode of putuserdata");
		
		
		
	}
	
	@Test
	public void deleteuserData() {
		
		Response res = delete("/34a5");
		
		System.out.println("---------Delete user -------");
		res.prettyPrint();
		
		Assert.assertEquals(res.statusCode(), 200, "Checkfor statuscode of deleteuserdata");
	}
	

}
