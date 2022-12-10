package project;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GitHubProject {
	
	String Base_URI = "https://api.github.com";
	String ssh = "ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAIOuh97cEMoH+lBN5rPOTm48cr0GTk0PwE7HZyAJtUugR";
	Integer id;
	RequestSpecification requestSpec;
	
	@BeforeClass
	public void before() {
		
		//given().auth().oauth2("token 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");
		
		requestSpec = new RequestSpecBuilder()
				.setContentType(ContentType.JSON)
				.addHeader("authorization", "token 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")
				.setBaseUri(Base_URI)
				.build();
	}
	
	@Test (priority = 1)
	public void get() {
		Response res = given().spec(requestSpec).get("/user/emails");
		System.out.println(res.asPrettyString());
	}
	
	@Test (priority = 2)
	public void post() {
		
		String reqBody = "{ \"title\": \"TestAPIKey\",  \"key\": \"ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAIOuh97cEMoH+lBN5rPOTm48cr0GTk0PwE7HZyAJtUugR\"}";

		Response response= given().spec(requestSpec).body(reqBody).when().post("/user/keys");
		
		System.out.println(response.asPrettyString());
		id= response.then().extract().path("id");
		System.out.println(id);
		System.out.println(response.then().extract().statusCode());
		
		response.then().assertThat().statusCode(201);
	}
	
	@Test (priority = 3)
	public void getKey() {

		Response res = given().spec(requestSpec).pathParam("keyId", id).get("/user/keys/{keyId}");
		System.out.println(res.asPrettyString());
		res.then().assertThat().statusCode(200);
	}
	
	@Test (priority = 4)
	public void delete() {
		Response res = given().spec(requestSpec).when().pathParam("keyId", id).delete("/user/keys/{keyId}");
		System.out.println(res.asPrettyString());
		res.then().assertThat().statusCode(204);
	}

	
	
	
	
	
}
