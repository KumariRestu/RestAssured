package session_23;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import session_22.EmployeeAddress;
import session_22.EmployeeNestedPojoClass;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;

public class DemoTestComplexNestedJSONObject {

	
	@Test
	public  void  createUser() throws JsonProcessingException {
		
		
		NestedJSONPojoClass  reqPayload = new NestedJSONPojoClass();
		
		reqPayload.setCompanyName("banglore it");
		reqPayload.setCity("btm");
		reqPayload.setState("KA");
		reqPayload.setPincode("560076");
		
		
		List<String>banks = new ArrayList<String>(Arrays.asList("hdfc", "bob", "icici"));
	
		reqPayload.setBankAccount(banks);
		
		
		EmployeeNestedPojoClass emp1 = new EmployeeNestedPojoClass();
		EmployeeNestedPojoClass emp2 = new EmployeeNestedPojoClass();

		EmployeeNestedPojoClass emp3 = new EmployeeNestedPojoClass();

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
		
		
		
		
		emp2.setAge(25);
		emp2.setFirstname("John");
		emp2.setGender("Male");
		emp2.setLastname("Doe");
		emp2.setSalary(1200.50);

		EmployeeAddress emp2Add = new EmployeeAddress();
		emp2Add.setCity("Hyderabad");
		emp2Add.setStreet("MG Road");
		emp2Add.setState("TS");
		emp2Add.setPincode(500081);

		emp2.setAddress(emp2Add);
		
		
		emp3.setAge(28);
		emp3.setFirstname("Emma");
		emp3.setGender("Female");
		emp3.setLastname("Stone");
		emp3.setSalary(1500.75);

		EmployeeAddress emp3Add = new EmployeeAddress();
		emp3Add.setCity("Bangalore");
		emp3Add.setStreet("Indiranagar");
		emp3Add.setState("KA");
		emp3Add.setPincode(560038);

		emp3.setAddress(emp3Add);
		
		
		
		List <EmployeeNestedPojoClass> employees = new ArrayList<EmployeeNestedPojoClass>(Arrays.asList(emp1, emp2, emp3));
		reqPayload.setEmployeeList(employees);
		
		//convert class object to json object as string
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		
			
		String payload = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(reqPayload);
		
		
		System.out.println("payload:" +payload);
		
		
		
		RequestSpecification req = given(); 
		
		Response res = req.baseUri("http://httpbin.org/post").
				contentType(ContentType.JSON).
				body(payload).
				post();

		
		res.prettyPrint();

Assert.assertEquals(res.statusCode(), 200, "check for status in DemoNestedJSONPayload ");
	}
	
	
}
