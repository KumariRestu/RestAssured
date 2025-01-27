package session_11;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Oauth2 {

	static String accessToken;
	
	
	@Test
	public void getAccessToken() {

		String clientID = "AShIO8lYLQplAcnlG-mLGKfjz_NvPfG_wHRVJjBtEzF9AIRd2cZtgnvOYGJZ_76tkPTtQ2TPcrBB";
		String clientSecret = "ECbK66zTms5-SpnvEssUXiDRV4jNiPlb07tSBrFuJJCZ46aO7kUs-tVju_7tKhU";
		
		RequestSpecification reqSpec = RestAssured.given();

		reqSpec.baseUri("https://api-m.sandbox.paypal.com");
		reqSpec.basePath("/v1/oauth2/token");

		// basic auth

		Response res = reqSpec.auth().preemptive().basic(clientID, clientSecret)
				.param("grant_type", "client_credentials").post();

		// print response status and response body
		System.out.println("Response: " + res.asPrettyString());

		System.out.println("Response status line:" + res.statusLine());

		// Assertions
		Assert.assertEquals(res.statusCode(), 200, "response statuscode does not match");

		// get access token from response body

		accessToken = res.getBody().path("access_token");
		System.out.println("AccessToken:" + accessToken);

	}
	@Test(dependsOnMethods = "getAccessToken")
	public void listInvoice() {
	Response res=	RestAssured.given()
		.auth().oauth2(accessToken)
		.queryParam("page", 1)
		.queryParam("page_size", 4)
		.queryParam("total_count_required", "true")
		.get("https://api-m.sandbox.paypal.com/v1/invoicing/invoices");
	
	
	System.out.println("-------listInvoice--------");
	
	System.out.println("Response body of listInvoice :" + res.getBody().asPrettyString());
	System.out.println("response Code of listInvoice  :" +res.statusCode());
	
	Assert.assertEquals(res.statusCode(), 200);
	
	}
	
	

}
