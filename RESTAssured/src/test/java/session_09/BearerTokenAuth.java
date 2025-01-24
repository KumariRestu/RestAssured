package session_09;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BearerTokenAuth {

	@Test
	public void BearerToken() {
		
		RequestSpecification resSpec = RestAssured.given();
	
		resSpec.baseUri("https://gorest.co.in/");
		resSpec.basePath("public/v2/users");
		
		JSONObject  payload = new JSONObject();
		payload.put("name", "red1");
		payload.put("gender", "female");
		payload.put("email", "she@gmail.com");
		payload.put("status", "active");
		
		String AuthToken = "Bearer 4eaa510ba5c967c11ae2297a02d56f3454665f1fd09fb5a1109aaa108256e92c";
		resSpec.header("Authorization", AuthToken)
		.contentType(ContentType.JSON)
		.body(payload.toJSONString());
		
		Response res = resSpec.post();
		
		
		Assert.assertEquals(res.statusCode(), 201, "StatusCode of PostApi is mismatched");
		System.out.println("Response status line:" +res.statusLine());
		System.out.println("ResponseBody:" +res.body().asPrettyString() );
	}

}
