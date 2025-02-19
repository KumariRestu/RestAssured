package session_21;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import session_20.Employee;

public class JSONArrayPojoClassDemo {

	@Test
	public void ceateEmployeeList() throws JsonProcessingException {

		// create 1st emp

		Employee emp1 = new Employee();

		emp1.setFirstName("Suresh");
		emp1.setLastname("Mehra");
		emp1.setGender("Male");
		emp1.setAge(32);
		emp1.setSalary(10.98);

		// create 2nd emp
		Employee emp2 = new Employee();
		emp2.setFirstName("Sita");
		emp2.setLastname("Mehra");
		emp2.setGender("Female");
		emp2.setAge(22);
		emp2.setSalary(1000000.98);

		// create 3rd emp
		Employee emp3 = new Employee();
		emp3.setFirstName("Geeta");
		emp3.setLastname("Dixit");
		emp3.setGender("Female");
		emp3.setAge(23);
		emp3.setSalary(10000.98);

		// create List of Employee

		List<Employee> listOfEmp = new ArrayList<Employee>();
		listOfEmp.add(emp1);
		listOfEmp.add(emp3);
		listOfEmp.add(emp2);

		// convert employee class objects to json array payload as string -->
		// serialisation

		ObjectMapper objMapper = new ObjectMapper();
		String jsonArrayPayload = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(listOfEmp);

		System.out.println("-----Employee class object to json array payload as string-----" + jsonArrayPayload);

		RequestSpecification req = RestAssured.given();
		Response res = req.baseUri("https://reqres.in/api/users").contentType(ContentType.JSON).body(jsonArrayPayload)
				.post();

		System.out.println("----------response body--------");
		res.prettyPrint();

		Assert.assertEquals(res.statusCode(), 201, "check for response ");

		// deserialization
		System.out.println("------------deserialized---------");

		ResponseBody resBody = res.getBody();

		JsonPath jsonPathView = resBody.jsonPath();
		
		List<Employee> allEmployees = jsonPathView.getList("", Employee.class);
		for (Employee emp:allEmployees) {
			System.out.println(emp.getFirstName());
		
		}
		
		
		
		
		
		
		
		
		
	}

}
