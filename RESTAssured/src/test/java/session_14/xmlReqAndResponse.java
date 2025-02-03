package session_14;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.List;

import org.hamcrest.*;

public class xmlReqAndResponse {

	@Test(priority = 1)
	public void AddPetwithJSONPayload() {

		String jsonData = "{\r\n" + "  \"id\": 0,\r\n" + "  \"category\": {\r\n" + "    \"id\": 0,\r\n"
				+ "    \"name\": \"string\"\r\n" + "  },\r\n" + "  \"name\": \"doggie\",\r\n" + "  \"photoUrls\": [\r\n"
				+ "    \"string\"\r\n" + "  ],\r\n" + "  \"tags\": [\r\n" + "    {\r\n" + "      \"id\": 0,\r\n"
				+ "      \"name\": \"string\"\r\n" + "    }\r\n" + "  ],\r\n" + "  \"status\": \"available\"\r\n" + "}";

		RequestSpecification reqSpec = RestAssured.given();

		reqSpec.baseUri("https://petstore.swagger.io/");
		reqSpec.basePath("v2/pet").header("Content-Type", "application/json").header("accept", "application/json")
				.body(jsonData);
		Response res = reqSpec.post();

		System.out.println("Response body" + res.asPrettyString());
		System.out.println("Response statusCode:" + res.getStatusCode());

		Assert.assertEquals(res.statusCode(), 200, "Check for statusCode");
	}

	@Test(priority = 2)
	public void AddPetWithXMLPayload()

	{

		String XMLData = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n" + "<Pet>\r\n" + "	<id>0</id>\r\n"
				+ "	<Category>\r\n" + "		<id>0</id>\r\n" + "		<name>string</name>\r\n" + "	</Category>\r\n"
				+ "	<name>doggie</name>\r\n" + "	<photoUrls>\r\n" + "		<photoUrl>string</photoUrl>\r\n"
				+ "	</photoUrls>\r\n" + "	<tags>\r\n" + "		<Tag>\r\n" + "			<id>0</id>\r\n"
				+ "			<name>string</name>\r\n" + "		</Tag>\r\n" + "	</tags>\r\n"
				+ "	<status>available</status>\r\n" + "</Pet>";

		Response resXML = RestAssured.given().baseUri("https://petstore.swagger.io/").basePath("v2/pet")
				.header("Content-Type", "application/xml").header("accept", "application/xml").body(XMLData).post();

		resXML.prettyPrint();
		System.out.println("Response StatusCode:" + resXML.statusCode());

		Assert.assertEquals(resXML.statusCode(), 200, "Check for status code of addPetWithXMLPayload");

		resXML.then().body("Pet.name", Matchers.equalTo("doggie"));

	}

	@Test (priority = 3)
	public void GetTravellersData() {

		// http://restapi.adequateshop.com/api/Tourist?page=1
		Response resGetTraveller = RestAssured.given().baseUri("http://restapi.adequateshop.com")
				.basePath("/api/Traveler").queryParam("page", 1)
				.header("accept", "application/xml").get();

		System.out.println("Response Body of GetTravellersData  :" + resGetTraveller.asPrettyString());
		System.out.println("Response StatusCode ofGetTravellersData:" + resGetTraveller.statusCode());

		XmlPath objXmlPath = new XmlPath(resGetTraveller.asString());

		String travellerName = objXmlPath.get("TravelerinformationResponse.travelers.Travelerinformation[0].name").toString();
		Assert.assertEquals(travellerName, "Developer", "check for traveller name.");

		//Verify total travelers to be 10

		List<String> listOfTravellers = objXmlPath.getList("TravelerinformationResponse.travelers.Travelerinformation");

		int totalTravelerCount = listOfTravellers.size();

		Assert.assertEquals(totalTravelerCount, 10,"check for total no. of traveller on page-1");


		//verify for name vano in travellers list
		List<String> listOfTravellersName = objXmlPath.getList("TravelerinformationResponse.travelers.Travelerinformation.name");

		//print all the names in the travellers list

		boolean found = false;
		for (String traveller :listOfTravellersName )
		{
			System.out.println(traveller);

			if(traveller.equals("vano"))
			{
				found = true;
				break;
			}


		}

		Assert.assertEquals(found, true);
		
		
		
	}

}
