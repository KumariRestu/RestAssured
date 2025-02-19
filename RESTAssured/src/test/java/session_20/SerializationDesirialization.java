package session_20;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SerializationDesirialization {

	@Test
	public void voidCreateJsonObjFromEmployeeClassObj() throws JsonProcessingException {

		Employee emp1 = new Employee();
		emp1.setFirstName("MArtin");
		emp1.setLastname("Claire");
		emp1.setGender("Female");
		emp1.setAge(30);
		emp1.setSalary(10000);

		// convert employee class object to json paylaod as string

		ObjectMapper objMapper = new ObjectMapper();

		String employeeJSON = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(emp1);

		System.out.println("employeeJSON: " + employeeJSON);

		RequestSpecification req = RestAssured.given();

		Response res = req.baseUri("http://httpbin.org/post").contentType(ContentType.JSON).body(employeeJSON).post();

		res.prettyPrint();
		Assert.assertEquals(res.statusCode(), 200, "Checkfor status of voidCreateJsonObjFromEmployeeClassObj");
	
		//convert Json string to class object 
	System.out.println(".................................................");
	Employee emp2 = objMapper.readValue(employeeJSON, Employee.class);
	System.out.println("FirstName -> "+ emp2.getFirstName());
	System.out.println("lastname -> "+ emp2.getLastname());

	System.out.println("gender -> "+ emp2.getGender());

	System.out.println("age -> "+ emp2.getAge());
	System.out.println("salary -> "+ emp2.getSalary());


	
	
	
	}
	


	
	
	
	
}
