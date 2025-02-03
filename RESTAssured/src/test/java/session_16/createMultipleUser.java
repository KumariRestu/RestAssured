package session_16;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;

public class createMultipleUser {

	
	@Test
	
	public void createUserUsingJSONArray() {
		
		
		
		JSONObject user1 = new JSONObject();
		user1.put("firstName", "Claire");
		user1.put("lastName", "Martin");
		user1.put("age", 28);
		user1.put("salary", 2000.58);
		
		
		JSONObject user2 = new JSONObject();
		user2.put("firstName", "Bobby");
		user2.put("lastName", "Martin");
		user2.put("age", 28);
		user2.put("salary", 1900.58);
		
		JSONObject user3 = new JSONObject();
		user3.put("firstName", "John");
		user3.put("lastName", "Martin");
		user3.put("age", 29);
		user3.put("salary", 1000.58);
		
		JSONArray userPayload = new JSONArray();
		
		userPayload.add(user1);
		userPayload.add(user2);
		userPayload.add(user3);
		
		
		RequestSpecification req  = RestAssured.given();
				
		req.baseUri("https://reqres.in/api/users").
				contentType(ContentType.JSON)
				.body(userPayload)
				.post();
		
		Response res = req.post();
		
		res.prettyPrint();
		
		Assert.assertEquals(res.statusCode(), 201, "check for status code of createUserUsingJSONArray");
		
		
		
		
	}
	
	
	@Test
	public void createUserUsingJSONList() {
		
		
		Map<String , Object > user1 = new HashMap<String , Object>();
		user1.put("firstName", "Claire");
		user1.put("lastName", "Martin");
		user1.put("age", 28);
		user1.put("salary", 2000.58);
		
		
		Map<String , Object > user2 = new HashMap<String , Object>();
		user2.put("firstName", "Bobby");
		user2.put("lastName", "Martin");
		user2.put("age", 28);
		user2.put("salary", 1900.58);
		
		
		Map<String , Object > user3 = new HashMap<String , Object>();
		user3.put("firstName", "John");
		user3.put("lastName", "Martin");
		user3.put("age", 29);
		user3.put("salary", 1000.58);
		
		
		//create Json array using List
		
		List<Map<String , Object >> JsonArrayListPayload = new ArrayList<>();
		JsonArrayListPayload.add(user1);
		JsonArrayListPayload.add(user2);
		JsonArrayListPayload.add(user3);
		
		
		
		
		RequestSpecification reqOfList  = RestAssured.given();
		
		reqOfList.baseUri("https://reqres.in/api/users").
				contentType(ContentType.JSON)
				.body(JsonArrayListPayload)
				.post();
		
		Response resOfList = reqOfList.post();
		
		resOfList.prettyPrint();
		
		Assert.assertEquals(resOfList.statusCode(), 201, "check for status code of createUserUsingJSONArray");
	}
		
	
	
	
	
}
