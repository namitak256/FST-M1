package activities;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Activity1 {

	// Set Base URL
	String ROOT_URI = "https://petstore.swagger.io/v2/pet";

	@Test(priority = 1)
	public void AddNewPet() {
		// Write the request body
		String reqBody = "{\"id\": 77111, \"name\": \"Riley\", \"status\": \"alive\"}";

		Response response = given().contentType(ContentType.JSON) // Set headers
				.body(reqBody).when().post(ROOT_URI); // Send POST request

		// Print response of POST request
		String body = response.getBody().asPrettyString();
		System.out.println(body);
	}

	@Test(priority = 2)
	public void simple_get_test() {
		Response response = given().contentType(ContentType.JSON) // Set headers
				.when().get(ROOT_URI + "/77111"); // Send GET request

		// Print response
		System.out.println(response.asPrettyString());
		// Assertions
		response.then().body("status", equalTo("alive"));
	}
	
	@Test(priority = 3)
	public void DeletePet() {
	    Response response = 
	        given().contentType(ContentType.JSON) // Set headers
	        .when().delete(ROOT_URI + "/77111"); // Send DELETE request
	    
	    // Assert DELETE operation
	    /* However, this will only work the first time
	    * the DELETE request is run, because
	    * the pet with id 77232 has already been deleted.
	    */
	    System.out.println(response.asPrettyString());
	    response.then().body("code", equalTo(200));
	    response.then().body("message", equalTo("77111"));
	}

}
