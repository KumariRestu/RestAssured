package session_12;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class deserializationDemo {

	@Test
	public void createUser() {
		
		
		RequestSpecification req = RestAssured.given();
		 req.baseUri("https://reqres.in");
		 req.basePath("/api/users");
		
		 
		 //create request body
		 JSONObject payload = new JSONObject();
		 payload.put("name", "redk");
		 payload.put("job", "QA");
		 
		 //perform post 
		 
		 Response res = req.contentType(ContentType.JSON).body(payload.toJSONString())
				 .post();
		 
		 ResponseBody resBody= res.getBody();
		 
		 //deserializde responsebody i.e. json response body to class object 
		 
		 JSONPostReqResponse resClass = resBody.as(JSONPostReqResponse.class);
		 
		 Assert.assertEquals(resClass.name, "redk", "check for name");
		 Assert.assertEquals(resClass.job, "QA", "check for job");
		 
		 
		 
	}
	
	
	
}
