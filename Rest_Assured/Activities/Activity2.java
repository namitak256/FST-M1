package activities;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Activity2 {

	String BASE_URI = "https://petstore.swagger.io/v2/user";
	
	@Test(priority = 1)
	public void post() {
		File file= new File("src\\test\\java\\activities\\data.json");
		FileInputStream fis;
		String reqBody;
		try {
			fis = new FileInputStream(file);
			byte[] bytes = new byte[(int) file.length()];
		    fis.read(bytes);
		    reqBody = new String(bytes, "UTF-8");
		    System.out.println(reqBody);
		    given().contentType(ContentType.JSON).body(reqBody).post(BASE_URI);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 2)
	public void get() {
		Response response= given().contentType(ContentType.JSON).pathParam("username", "justinc256").get(BASE_URI+"/{username}");
		System.out.println(response.asPrettyString());
	}
	
	@Test(priority = 3)
	public void delete() {
		Response response= given().contentType(ContentType.JSON).pathParam("username", "justinc256").delete(BASE_URI+"/{username}");
		System.out.println(response.asPrettyString());
		
	}
}
