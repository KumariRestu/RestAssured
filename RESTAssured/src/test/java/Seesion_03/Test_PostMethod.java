package Seesion_03;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import org.json.simple.JSONObject;
import static io.restassured.RestAssured.*;

public class Test_PostMethod {

	
	
	
	@Test
	public void test03() {
	
	JSONObject jsonData = new JSONObject();
	jsonData.put("name", "REstu");	
	jsonData.put ("job", "QA");
	
	baseURI = "https://reqres.in/api/users";
	given().header("Content-type","application/json").
	contentType(ContentType.JSON).
	body(jsonData.toJSONString()).
	when().post().		
	then().statusCode(201).log().all();
}
}