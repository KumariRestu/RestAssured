package session_22;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;

public class DemoNestedJSONPayload {

	@Test
	public void createUser() throws JsonProcessingException {

		EmployeeNestedPojoClass emp1 = new EmployeeNestedPojoClass();
		emp1.setAge(30);
		emp1.setFirstname("red");
		emp1.setGender("Female");
		emp1.setLastname("Kim");
		emp1.setSalary(1000.34);

		EmployeeAddress emp1Add = new EmployeeAddress();
		emp1Add.setCity("vijawada");
		emp1Add.setStreet("park avenue");
		emp1Add.setState("AP");
		emp1Add.setPincode(530012);

		emp1.setAddress(emp1Add);

		// convert class object to json object as string
		ObjectMapper obj = new ObjectMapper();

		String jsonPayload = obj.writerWithDefaultPrettyPrinter().writeValueAsString(obj);

		RequestSpecification req = given();

		Response res = req.baseUri("http://httpbin.org/post").
				contentType(ContentType.JSON).
				body(jsonPayload).
				post();

		
		res.prettyPrint();

Assert.assertEquals(res.statusCode(), 200, "check for status in DemoNestedJSONPayload ");
		
		
		
		
	}

}
