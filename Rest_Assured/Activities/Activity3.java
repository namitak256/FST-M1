package activities;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static org.hamcrest.CoreMatchers.equalTo;

import static io.restassured.RestAssured.given;

public class Activity3 {
	RequestSpecification reqspec;
	ResponseSpecification resspec;

	@BeforeTest
	public void before() {
		reqspec= new RequestSpecBuilder()
				.setContentType(ContentType.JSON)
				.setBaseUri("https://petstore.swagger.io/v2/pet")
				.build();
		resspec= new ResponseSpecBuilder()
				.expectStatusCode(200)
				.expectContentType(ContentType.JSON)
				.expectBody("status", equalTo("alive"))
				.build();
				
	}
	
	@DataProvider
	public Object[][] provider(){
		Object[][] testData = new Object[][] { 
		    { 77111, "Riley", "alive" }, 
		    { 77222, "Hansel", "alive" } 
		};
		return testData;
	}
	
	@Test(priority = 1)
	public void post() {
		String req1="{\"id\": 77111, \"name\": \"Riley\", \"status\": \"alive\"}";
		
		Response response= given().spec(reqspec).body(req1).when().post();
		System.out.println(response.asPrettyString());
		
		String req2="{\"id\": 77222, \"name\": \"Hansel\", \"status\": \"alive\"}";
		
		response= given().spec(reqspec).body(req2).when().post();
		System.out.println(response.asPrettyString());
		
		response.then().spec(resspec);
	}
	
	@Test(dataProvider = "provider",priority = 2)
	public void get(Integer id, String name, String status) {
		Response res = given().spec(reqspec).pathParam("petId", id).get("/{petId}");
		System.out.println(res.asPrettyString());
		
		res.then().spec(resspec);
	}
	
	@Test(dataProvider = "provider",priority = 3)
	public void delete(Integer id, String name, String status) {
		Response res = given().spec(reqspec).pathParam("petId", id).delete("/{petId}");
		System.out.println(res.asPrettyString());
		res.then().assertThat().body("code", equalTo(200));
	}
}
