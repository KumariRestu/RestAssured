package session_13;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;

public class reqSpecification {

	@Test
	public void retrieveRequestSpecification() {

		JSONObject jsonData = new JSONObject();
		jsonData.put("name", "redQA");
		jsonData.put("job", "QA1");

		RequestSpecification reqSpec = RestAssured.given();
		reqSpec.baseUri("https://reqres.in");
		reqSpec.basePath("/api/users");
		reqSpec.contentType(ContentType.JSON).body(jsonData.toJSONString());
		
		
		//query request specification 
		
		 QueryableRequestSpecification queryReq=SpecificationQuerier.query(reqSpec);
		
		 //getbase URI
		 
		 System.out.println("base URl:" +queryReq.getBaseUri() +queryReq.getBasePath());
		 System.out.println("payload:" +queryReq.getBody());

		 //for headeres 
		 Headers allheader =queryReq.getHeaders();
		 System.out.println("headers direct print :" +allheader);
		 
		 System.out.println("\n-----header infor------\n");
		 for(Header h: allheader) {
			 System.out.println("Header info:" +h.getName() +":" +h.getValue());
		 }
		 
		
		
		
		
		
		
	}

}
