package Seesion_03;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class Test_DeleteMethod {

	@Test
	
	public void test06() {
		baseURI = "https://reqres.in/api/users/323";
		given().
		when().delete().
		then().
		log().all().
		statusCode(204);
	}
	
	
}
