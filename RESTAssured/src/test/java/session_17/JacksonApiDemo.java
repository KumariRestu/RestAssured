package session_17;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Map.Entry;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class JacksonApiDemo {

	@Test
	public void createUser() {

		// create objectMapper class instance
		ObjectMapper objectMapper = new ObjectMapper();
		// create object node i.e json node
		ObjectNode userDetails = objectMapper.createObjectNode();
		userDetails.put("firstName", "Prerna");
		userDetails.put("lastName", "Gupta");
		userDetails.put("age", 28);
		userDetails.put("salary", 10000.56);
		userDetails.put("IsMarried", false);

		userDetails.set("Hobbies", objectMapper.convertValue(Arrays.asList("Cooking", "Music"), JsonNode.class));

		ObjectNode techSkills = objectMapper.createObjectNode();
		techSkills.put("Programming language", "Java");
		techSkills.put("WebAutomation", "Selenium");
		techSkills.put("API testing", "Rest Assured");

		userDetails.set("TechSkill", techSkills);

		// print userDetails JSON on=bject
		try {
			String userDetailsAsString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(userDetails);
			System.out.println("Created JSON Node is : " + userDetailsAsString);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Retrieve field value)

		System.out.println("first name is :" + userDetails.get("firstName").asText());
		System.out.println("is married :" + userDetails.get("IsMarried").asBoolean());
		System.out.println("Techskills:" + userDetails.get("TechSkill").get("WebAutomation").asText());

		Iterator<String> fieldNameIterator = userDetails.fieldNames();
		while (fieldNameIterator.hasNext()) {
			System.out.println("all fieldname :" + fieldNameIterator.next());
		}

		Iterator<JsonNode> ValuesIterator = userDetails.elements();
		while (ValuesIterator.hasNext()) {
			System.out.println("all Values :" + ValuesIterator.next());
		}

		Iterator<Entry<String, JsonNode>> keyValueEntry = userDetails.fields();
		while (keyValueEntry.hasNext()) {

			Entry<String, JsonNode> node = keyValueEntry.next();
			node.getKey();
			System.out.println("key:" + node.getKey() + " value:" + node.getValue());
		}

		// remove field from json object or object node

		System.out.println("removed value" + userDetails.remove("firstName").asText());

		// update
		userDetails.put("lastName", "Sharma").asText();

		techSkills.put("Programming language", "C#");
		userDetails.set("TechSkill", techSkills);

		try {
			String userDetailsAsString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(userDetails);
			System.out.println("Created JSON Node after delete and update  : " + userDetailsAsString);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestSpecification reqSpec = RestAssured.given();

		// specify URL
		reqSpec.baseUri("https://reqres.in/api/users");
		reqSpec.contentType(ContentType.JSON);
		reqSpec.body(userDetails);

		// perform post request
		Response response = reqSpec.post();

		System.out.println("-------------Print Http response body-----------------------------");
		response.prettyPrint();

		// Validate the status code
		Assert.assertEquals(response.statusCode(), 201, "Check for status code.");
	}
}
