package Seesion_03;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
public class Test_PatchMethod {

	
	@Test

	public void test05() {
		JSONObject jsonData = new JSONObject();
		
		jsonData.put("name", "Red");	
		jsonData.put ("job", "KTQA");
		
	
	

	baseURI= "https://reqres.in/api/users/323";
	given().header("Content-type","application/json").
	contentType(ContentType.JSON).
	body(jsonData.toJSONString()).
	when().patch().		
	then().statusCode(200).log().all();
	
	}
}
