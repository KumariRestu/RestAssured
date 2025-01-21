package Seesion_03;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;

public class Test_PutMethod {

	// /api/users/323
	
	

	@Test
	public void test04() {
		
		JSONObject jsonData = new JSONObject();
		jsonData.put("name", "Red");	
		jsonData.put ("job", "testQA");
		
	
	

	baseURI= "https://reqres.in/api/users/323";
	given().header("Content-type","application/json").
	contentType(ContentType.JSON).
	body(jsonData.toJSONString()).
	when().put().		
	then().statusCode(200).log().all();
	
	}
}
